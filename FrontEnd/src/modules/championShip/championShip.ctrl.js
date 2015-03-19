(function () {
    var championShipModule = angular.module('championShipModule');

    championShipModule.controller('championShipCtrl', ['$scope', 'championShipService', function ($scope, championShipService) {
            championShipService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
