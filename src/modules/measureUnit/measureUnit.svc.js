(function(){
    var measureUnitModule = angular.module('measureUnitModule');
    
    measureUnitModule.service('measureUnitService', ['CRUDBase','measureUnit.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
