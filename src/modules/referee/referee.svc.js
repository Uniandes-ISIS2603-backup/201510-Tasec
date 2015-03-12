(function(){
    var refereeModule = angular.module('refereeModule');
    
    refereeModule.service('refereeService', ['CRUDBase','referee.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
