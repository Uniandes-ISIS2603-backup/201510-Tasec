(function () {
    var cityModule = angular.module('paqueteModule');

    cityModule.controller('paqueteCtrl', ['$scope', 'paqueteService', function ($scope, paqueteService) {
            paqueteService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
