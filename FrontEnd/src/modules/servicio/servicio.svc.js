(function(){
    var servicioModule = angular.module('servicioModule');
    
    servicioModule.service('servicioservice', ['CRUDBase','servicio.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
