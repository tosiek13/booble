mainApp.controller("GameMenuController", function ($scope, $rootScope) {
    $scope.initGame = function () {
        $rootScope.userLamb = true;
        $rootScope.userTurn = true;
        $rootScope.lambPosition = { x: 2, y: 7 };
        $rootScope.wolfsPositions = [ { x: 1, y: 0 }, { x: 3, y: 0 }, { x: 5, y: 0 }, { x: 7, y: 0 } ];
    }
});