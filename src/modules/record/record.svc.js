(function(){
    var recordModule = angular.module('recordModule');
    
    recordModule.service('recordService', ['CRUDBase','record.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
