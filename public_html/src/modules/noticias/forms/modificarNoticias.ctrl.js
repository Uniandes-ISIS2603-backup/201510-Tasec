/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {
    var adminModule = angular.module('adminModule');

    adminModule.controller('adminCtrl', ['$scope', 'adminservice', function ($scope, adminservice) {
            
            //Log-in
            this.setLogin= function(valor){
                if(valor==='si'){
                    this.login=true;
                }
                else{
                    this.login=false
                }
            }
            
            
            //Pestañas
            this.tab=1;
            this.setTab = function(tabE){this.tab=tabE;} 
            this.isSet= function(valorSeleccionado){return this.tab === valorSeleccionado;}
            
            adminservice.extendCtrl(this, $scope);
            this.fetchRecords();
            this.createRecords = function(){
                this.editMode = true;
                $scope.currentRecord = {};
                console.log("Se despliega formulario de creación de registro");
             };
        }]);
})();