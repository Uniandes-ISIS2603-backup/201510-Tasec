(function () {
	var mod1 = angular.module('serviciosModule');

	mod1.controller('serviciosCtrl', ['$scope', 'CRUDUtils', 'servicios.context', function ($scope, CRUDUtils, context){
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                        fetchRecords();
                         
		}]);   
         
      
})();