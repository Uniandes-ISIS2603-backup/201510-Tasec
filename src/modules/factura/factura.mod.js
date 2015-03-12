(function () {
    var facturaModule = angular.module('facturaModule', ['CrudModule', 'MockModule']);

    facturaModule.constant('factura.context', 'facturas');

    facturaModule.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
