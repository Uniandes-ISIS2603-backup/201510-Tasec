(function(){
    var countryModule = angular.module('foroModule');
    
    countryModule.service('foroService', ['CRUDBase','foro.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
