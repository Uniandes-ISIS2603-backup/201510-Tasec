(function(){
    var cityModule = angular.module('paqueteModule');
    
    cityModule.service('paqueteService', ['CRUDBase','paquete.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
