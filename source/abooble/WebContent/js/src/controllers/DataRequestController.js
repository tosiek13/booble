mainApp.controller("DataRequestController", function ($scope, MessageService) {
    $scope.requestRooms = function () {
        var message = { messageType: 2 }
        MessageService.sendMessage(message);
    }
});