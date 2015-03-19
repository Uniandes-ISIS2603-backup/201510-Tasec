(function () {
    var facturaModule = angular.module('facturaModule');

    facturaModule.controller('facturaCtrl', ['$scope', 'facturaService', function ($scope, facturaService) {
            facturaService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
