(function () {
    var countryModule = angular.module('foroModule');

    countryModule.controller('foroCtrl', ['$scope', 'foroService', function ($scope, foroService) {
            foroService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
