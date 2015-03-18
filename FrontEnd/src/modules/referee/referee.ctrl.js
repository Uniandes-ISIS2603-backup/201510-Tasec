(function () {
    var refereeModule = angular.module('refereeModule');

    refereeModule.controller('refereeCtrl', ['$scope', 'refereeService', function ($scope, refereeService) {
            refereeService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
