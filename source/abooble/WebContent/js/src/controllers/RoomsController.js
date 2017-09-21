mainApp.controller("RoomsController", function ($scope, MessageService) {
    var rooms = [];
    var room = {};
    var startRoom = {};

    $scope.init = function () {
        MessageService.registerRoomController(this);
        this.getRooms();
        this.startRoom = { bootsAmount: 1 };
    }

    $scope.getRooms = function () {
        var message = { messageType: 2 }
        MessageService.sendMessage(message);
    }

    $scope.setRooms = function (rooms) {
        this.rooms = rooms;
        $scope.$apply();
    }

    $scope.joinRoom = function (roomId) {
        var message = { messageType: 3, roomId: roomId };
        MessageService.sendMessage(message);
        this.getRooms();
    }

    $scope.createNewRoom = function () {
        var message = { messageType: 10, playersAmount: this.startRoom.bootsAmount };
        MessageService.sendMessage(message);
        this.getRooms();
    }

    $scope.leaveRoom = function (roomId) {
        var message = { messageType: 9 };
        MessageService.sendMessage(message);
        this.getRooms();
    }

    $scope.setRoom = function (room) {
        this.room = room;
    }

    $scope.updateRound = function (room) {
        this.room = room;
        $scope.$apply();
    }
});