(function () {
    var servicioModule = angular.module('servicioModule');

    servicioModule.controller('servicioCtrl', ['$scope', 'servicioservice', function ($scope, servicioservice) {
            servicioservice.extendCtrl(this, $scope);
            this.fetchRecords();
            this.createRecords = function(){
                this.editMode = true;
                $scope.currentRecord = {};
                console.log("Se despliega formulario de creación de registro");
             };
        }]);
})();
