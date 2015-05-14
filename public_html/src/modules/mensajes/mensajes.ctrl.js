/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {
    var mensajesModule = angular.module('mensajesModule', []);

    mensajesModule.controller('mensajesController', ['$scope', function ($scope) {
            $scope.display="mensajes";
            $scope.setDisplay=function(nDisplay){
                $scope.display=nDisplay;
            }
            
            $scope.displayActual= function(actual){
                return $scope.display === actual;
            }
    }]);
})();