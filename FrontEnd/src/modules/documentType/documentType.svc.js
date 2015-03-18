(function(){
    var documentTypeModule = angular.module('documentTypeModule');
    
    documentTypeModule.service('documentTypeService', ['CRUDBase','documentType.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
