(function () {
    var championShipModule = angular.module('championShipModule', ['CrudModule', 'MockModule']);

    championShipModule.constant('championShip.context', 'championShips');

    championShipModule.config(['championShip.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
