/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {
    var regProveedorModule = angular.module('regProveedorModule', ['CrudModule', 'MockModule']);

    regProveedorModule.constant('proveedor.context', 'proveedor');

    regProveedorModule.config(['servicio.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
