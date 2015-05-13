/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (){
    var actualizarInfoModule = angular.module('actualizarInfoModule',[]);
    
    actualizarInfoModule.controller('actualizarInfoControlador', ['$scope', function($scope){
        this.tab=1;

        this.setTab= function(valorSeleccionado){
            this.tab=valorSeleccionado;
        }
        
        this.isSet= function(valorSeleccionado){
            return this.tab===valorSeleccionado;
        }
        
        
    }]);
    
})();