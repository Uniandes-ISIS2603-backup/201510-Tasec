(function(){
    var facturaModule = angular.module('facturaModule');
    
    facturaModule.service('facturaService', ['CRUDBase','factura.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
