(function () {

    var mainApp = angular.module('mainApp', [
        'ngRoute',
        'servicioModule', 
        'facturaModule', 
        'foroModule', 
        'paqueteModule', 
        'prizeModule' 
        
    ]);

    mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/servicio', {templateUrl: 'src/modules/servicio/servicio.tpl.html'})
                .when('/factura', {templateUrl: 'src/modules/factura/factura.tpl.html'})
                .when('/foro', {templateUrl: 'src/modules/foro/foro.tpl.html'})
                .when('/paquete', {templateUrl: 'src/modules/paquete/paquete.tpl.html'})
                .when('/prize', {templateUrl: 'src/modules/prize/prize.tpl.html'})
                .otherwise('/');
        }]);
})();
