(function () {
    var addressModule = angular.module('addressModule');

    addressModule.controller('addressCtrl', ['$scope', 'addressService', function ($scope, addressService) {
            addressService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
