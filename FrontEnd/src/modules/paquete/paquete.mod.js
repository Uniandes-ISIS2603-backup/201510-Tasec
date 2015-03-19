(function () {
    var cityModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);

    cityModule.constant('paquete.context', 'paquetes');

    cityModule.config(['paquete.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
