(function(){
    var memberModule = angular.module('memberModule');
    
    memberModule.service('memberService', ['CRUDBase','member.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
