(function () {
    var memberModule = angular.module('memberModule');

    memberModule.controller('memberCtrl', ['$scope', 'memberService', function ($scope, memberService) {
            memberService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
