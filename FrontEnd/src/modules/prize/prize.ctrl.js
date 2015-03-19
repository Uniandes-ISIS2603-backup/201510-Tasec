(function () {
    var prizeModule = angular.module('prizeModule');

    prizeModule.controller('prizeCtrl', ['$scope', 'prizeService', function ($scope, prizeService) {
            prizeService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
