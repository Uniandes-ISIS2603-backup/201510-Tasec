(function () {
    var recordModule = angular.module('recordModule');

    recordModule.controller('recordCtrl', ['$scope', 'recordService', function ($scope, recordService) {
            recordService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
