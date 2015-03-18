(function(){
    var userModule = angular.module('userModule');
    
    userModule.service('userService', ['CRUDBase','user.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
