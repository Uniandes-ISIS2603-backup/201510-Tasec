/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 (function(){
      (function () {
 
      var mainApp = angular.module('mainApp', 
      ['ngRoute','servicioModule','regProveedorModule','regClienteModule','actualizarInfoModule','adminModule']);
      
      //Configuración de navegación entre rutas
      //Determina qué template cargar cuando el navegador busque una URL específica
      mainApp.config(['$routeProvider', function ($routeProvider) {
              $routeProvider.when('/', {
                 templateUrl: 'src/modules/home/home.html'
             }).when('/servicio',{
                 templateUrl: 'src/modules/servicio/servicio.tpl.html',
             }).when('/admin',{
                 templateUrl: 'src/modules/administrador/admin.html'
             }).when('/item',{
                 templateUrl: 'src/modules/item/item.html'
             }).when('/catalogo',{
                 templateUrl: 'src/modules/catalogo/catalogo.html'
             }).when('/registrarse',{
                 templateUrl: 'src/modules/registrarCliente/registrarCliente.html'
             }).when('/actualizarInfo',{
                 templateUrl: 'src/modules/actualizarInfo/actualizarInfo.html'
             }).when('/registrarProveedor',{
                 templateUrl: 'src/modules/registrarProveedor/registrarProveedor.tpl.html'
             }).when('/AdministrarCatalogo',{
                 templateUrl: 'src/modules/administrador/AdministrarCatalogo.html'
              }).when('/monitoreoRendimiento',{
                 templateUrl: 'src/modules/administrador/monitoreoRendimiento.html'
             
             }).when('/validarProveedores',{
                 templateUrl:'src/modules/administrador/validarProveedores.html'
             }).when('/buscar',{
                 templateUrl:'src/modules/buscar/buscar.html'
              }).otherwise('/',{
                 redirectTo:'src/modules/home/home.html'
             });
         }]);
 })();
 })();
 
 
 
       //mainApp.directive("librerias", function(){
      //    return {
      //        restrict:'E',
      //        templateUrl:'src/modules/librerias.html'
      //    };
      //});