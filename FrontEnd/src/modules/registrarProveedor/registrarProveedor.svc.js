/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(){
    var regProveedorModule = angular.module('regProveedorModule');
    
    regProveedorModule.service('proveedorservice', ['CRUDBase','proveedor.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
