(function(){
    var addressModule = angular.module('addressModule');
    
    addressModule.service('addressService', ['CRUDBase','address.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
