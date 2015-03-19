(function () {
    var userModule = angular.module('userModule');

    userModule.controller('userCtrl', ['$scope', 'userService', function ($scope, userService) {
            userService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
