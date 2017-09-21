mainApp.controller("LoginController", function ($scope, MessageService) {
    var isLogged = false;
    var nick = { value: "" };

    
	$scope.init = function () {
        MessageService.registerLoginController(this);
      };
    
    
    $scope.login = function () {
        var message = { messageType: 8, nick: this.nick.value }
        MessageService.sendMessage(message);
    }
    
    $scope.setLogin = function(status){
    	if(status == "OK"){
    		this.isLogged = true;
    	} else {
    		alert("Unavaiable nick!!!");
    		this.nick.value = "";
    		$scope.$apply();
    	}
    		
    }
});