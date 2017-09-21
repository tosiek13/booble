mainApp.controller("MessageController", function ($scope, MessageService) {
  $scope.sendMessage = function () {
    MessageService.sendMessage("My message !!!!!!!!");
  },

  $scope.getRooms = function () {
    MessageService.sendMessage({ messageType: 2 });
  }
});