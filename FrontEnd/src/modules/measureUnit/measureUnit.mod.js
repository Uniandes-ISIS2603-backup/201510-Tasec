(function () {
    var measureUnitModule = angular.module('measureUnitModule', ['CrudModule', 'MockModule']);

    measureUnitModule.constant('measureUnit.context', 'measureUnits');

    measureUnitModule.config(['measureUnit.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
