/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {
    var regClienteModule = angular.module('regClienteModule', ['CrudModule', 'MockModule']);


    regClienteModule.constant('cliente.context', 'cliente');

    regClienteModule.config(['cliente.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);


    regClienteModule.controller('registrarCliente', ['$scope', 'proveedorservice', function ($scope, proveedorservice) {
            proveedorservice.extendCtrl(this, $scope);
            this.fetchRecords();
            this.addCliente = function(){
                this.editMode = true;
                $scope.currentRecord = {};
                console.log("Se despliega formulario de creación de registro");
             };
        }]);
    
    
    regClienteModule.service('clienteservice', ['CRUDBase','cliente.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
