(function () {
    var servicioModule = angular.module('servicioModule');

    servicioModule.controller('servicioCtrl', ['$scope', 'servicioservice', function ($scope, servicioservice) {
            servicioservice.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
