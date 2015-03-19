(function(){
    var championShipModule = angular.module('championShipModule');
    
    championShipModule.service('championShipService', ['CRUDBase','championShip.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
