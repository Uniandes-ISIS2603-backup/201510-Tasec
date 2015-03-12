(function () {
    var documentTypeModule = angular.module('documentTypeModule');

    documentTypeModule.controller('documentTypeCtrl', ['$scope', 'documentTypeService', function ($scope, documentTypeService) {
            documentTypeService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();
