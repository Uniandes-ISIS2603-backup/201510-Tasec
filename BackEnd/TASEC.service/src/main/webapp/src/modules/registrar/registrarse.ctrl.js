/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {
    var registrar = angular.module('registrar', ['CrudModule', 'MockModule']);


    registrar.constant('cliente.context', 'cliente');

    registrar.config(['cliente.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);


    registrar.controller('registrarCliente', ['$scope', function ($scope) {
            
        }]);
    registrar.constant('registrar.skipMock', true);

     registrar.config(['registrar.context', 'MockModule.urlsProvider','registrar.skipMock', function (context, urlsProvider, skipMock) {
             urlsProvider.registerUrl(context, skipMock);
         }]);
    
    registrar.service('clienteservice', ['CRUDBase','cliente.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
