mainApp.factory('MessageService', ['$rootScope', function ($rootScope) {
        // var socket = new WebSocket('wss://echo.websocket.org');
//     var socketAddress = location.origin.replace(/^http/, 'wss')
//     var socket = new WebSocket(socketAddress + '/room');
//    var socket = new WebSocket('ws://abooble.eu-gb.mybluemix.net/abooble/room');
//     var socket = new WebSocket('wss://abooble.eu-gb.mybluemix.net/room');
	var socket = new WebSocket('ws://localhost:8080/abooble/room');
    var Service = {};
    var messages = [];
    var controllers = {
        roomsController: null,
        drawingController: null,
        loginController:null
    }

    socket.onopen = function () {
        console.log("Socket has been opened!");
    }

    socket.onerror = function () {
         alert("Socket error !!!");
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
            case "7": /*ROUND_SUMMARY*/
                // controllers.drawingController.
                controllers.drawingController.drawOponents(data.room);
                controllers.roomsController.updateRound(data.room);
                break;
            case "8": /*LEFT_ROOM*/
                controllers.loginController.setLogin(data.status);
                break;
             case "9": /*LEFT_ROOM*/
                controllers.roomsController.setRoom(null);
                controllers.drawingController.clear();
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

    Service.registerDrawingController = function (controller) {
        controllers.drawingController = controller;
    }
    
    Service.registerLoginController = function (controller) {
        controllers.loginController = controller;
    }

    return Service;
}])