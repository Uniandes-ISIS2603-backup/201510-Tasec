(function () {
    var measureUnitModule = angular.module('measureUnitModule');

    measureUnitModule.controller('measureUnitCtrl', ['$scope', 'measureUnitService', function ($scope, measureUnitService) {
            measureUnitService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
