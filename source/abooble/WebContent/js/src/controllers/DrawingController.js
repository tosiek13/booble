mainApp.controller("DrawingController", function ($scope, MessageService, MouseActionService) {

  $scope.init = function () {
    this.draw = new SVG('drawing').size(800, 450);
    this.draw.on('mousedown', function (event) {
      MouseActionService.onClick(event.offsetY, event.offsetX);
    });
    this.draw.on('mouseup', function (event) {
      
    });
    this.draw.on('mousemove', function (event) {
      MouseActionService.onMove(event.offsetY, event.offsetX);
    });

    MouseActionService.setDraw(this.draw);
    MessageService.registerDrawingController(this);
  };

  $scope.sendMessage = function () {
    MessageService.sendMessage("My message !!!!!!!!");
  }

  $scope.drawOponents = function (room) {
    this.draw.clear();
    for (var i in room.gamesters) {
      gamester = room.gamesters[i];
      this.draw.circle(gamester.move.radius).attr({ cx: gamester.move.x, cy: gamester.move.y });
    }
  }

  $scope.clear = function () {
    this.draw.clear();
  }

  $scope.lockForSeconds = function (seconds) {
    this.lock.isLocked = true;
    setTimeout(function () { this.lock.isLocked = false; }.bind(this), 3000);
  }
});