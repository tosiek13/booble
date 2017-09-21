mainApp.factory('MessageGenerator', ['$rootScope', function ($rootScope) {
    // var socket = new WebSocket('wss://echo.websocket.org');
    var socket = new WebSocket('ws://localhost:8080/booble/room');
    var Service = {};
    var messages = [];
    var controllers = {
        roomsController: null
    }

    socket.onopen = function () {
        console.log("Socket has been opened!");
    }

    socket.onerror = function () {
        // alert("Socket error !!!");
    }
    socket.onmessage = function (message) {
        console.log("Service got message: " + JSON.parse(message.data));
        var data = JSON.parse(message.data);
        switch (data.messageType) {
            case "2":
                controllers.roomsController.setRooms(data.rooms);
                break;
            case "4":/*room info*/
                controllers.roomsController.setRoom(data.room);
                break;
        }
        // messages.push(message);
    };

    Service.sendMessage = function (message) {
        if (socket.readyState === socket.CONNECTING) {
            setTimeout(function (message) {
                this.sendMessage(message);
            }.bind(this, message), 50);
        } else {
            socket.send(JSON.stringify(message));
        }
    }

    Service.isMessage = function () {
        if (fruits.length > 0)
            return true;
        return false;
    }

    Service.getMessage = function () {
        return messages.shift();
    }

    Service.registerRoomController = function (controller) {
        controllers.roomsController = controller;
    }

    return Service;
}])