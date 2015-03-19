(function () {
    var servicioModule = angular.module('servicioModule', ['CrudModule', 'MockModule']);

    servicioModule.constant('servicio.context', 'servicios');

    servicioModule.config(['servicio.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
