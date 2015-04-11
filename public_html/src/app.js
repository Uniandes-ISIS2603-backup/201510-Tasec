 
 

(function(){
    (function () {

        var mainApp = angular.module('mainApp', 
        ['ngRoute', 'registrar']);

        //Configuración de navegación entre rutas
        //Determina qué template cargar cuando el navegador busque una URL específica
        mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/', {
                templateUrl: 'src/modules/home/home.html'
            }).when('/admin',{
                templateUrl: 'src/modules/registrar/registrarse.html'
            }).when('/item',{
                templateUrl: 'src/modules/item/item.html'
            }).when('/catalogo',{
                templateUrl: 'src/modules/catalogo/catalogo.html'
            }).when('/registrarse',{
                templateUrl: 'src/modules/registrar/registrarse.html'
            }).when('/administrarCatalogo',{
                templateUrl: 'src/modules/administrador/administrarCatalogo.html'
            }).when('/buscar',{
                templateUrl:'src/modules/buscar/buscar.html'
            }).when('/noticias',{
                templateUrl:'src/modules/noticias/noticias.html'
            }).when('/calificacion',{
                templateUrl:'src/modules/calficacion.html'
            }).otherwise('/',{
                redirectTo:'src/modules/home/home.html'
            });  
        }]);
    
        mainApp.controller('mainController',['$scope', function($scope){
            
         
                       
            
            //usuarios
            //admin, proveedor, cliente
            $scope.setUsuario=function(usuario){$scope.tipo=usuario;}
            $scope.usuarioActual= function(actual){
                return $scope.tipo === actual;
            }
            
            //
            
            this.logout= function(){ this.tipo='normal';}
            this.login=function(nombre){
                $scope.logged='true';
                $scope.nombre=nombre;
            }

        }]);
            
        
    })();
 

 
 
})();