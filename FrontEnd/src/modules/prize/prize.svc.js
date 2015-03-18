(function(){
    var prizeModule = angular.module('prizeModule');
    
    prizeModule.service('prizeService', ['CRUDBase','prize.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
