mainApp.factory('MouseActionService', ['$rootScope', 'MessageService', function ($rootScope, MessageService) {
    var Service = {};
    var f = {
        resetState: function () {
            Service.state = {
                isClear: true,
                isCenterSelected: false,
                isAllSelected: false,

                yCenter: null,
                xCenter: null,
                circle: null,
            }
        }
    };
    f.resetState();

    Service.onClick = function (yPosition, xPosition) {
        if (this.state.isAllSelected) {
            f.resetState();
        }
        if (this.state.isClear) {
            this.state.yCenter = yPosition;
            this.state.xCenter = xPosition;
            this.state.isClear = false;
            this.state.isCenterSelected = true;
        } else if (this.state.isCenterSelected) {
            var radius = this.getRadius(this.state.yCenter, this.state.xCenter, yPosition, xPosition);
            this.state.isCenterSelected = false;
            this.state.isAllSelected = true;
            Service.drawCircle(yPosition, xPosition);

            MessageService.sendMessage({ messageType: 6, xCenter: this.state.xCenter, yCenter: this.state.yCenter, radius: radius });
        }
    }

    Service.onMove = function (yPosition, xPosition) {
        if (this.state.isCenterSelected) {
            this.drawCircle(yPosition, xPosition);
        }
    }

    Service.drawCircle = function (yPosition, xPosition) {
        this.draw.clear();
        var radius = this.getRadius(this.state.yCenter, this.state.xCenter, yPosition, xPosition);
        this.draw.circle(radius).attr({ cx: this.state.xCenter, cy: this.state.yCenter });
    }

    Service.getRadius = function(yCenter, xCenter, yPosition, xPosition){
        return parseInt(Math.sqrt(Math.pow(yCenter - yPosition, 2) + Math.pow(xCenter - xPosition, 2))); 
    }

    Service.setDraw = function (draw) {
        this.draw = draw;
    }
    return Service;
}])