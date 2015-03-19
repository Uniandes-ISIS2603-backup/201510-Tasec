(function () {
    var countryModule = angular.module('foroModule', ['CrudModule', 'MockModule']);

    countryModule.constant('foro.context', 'foros');

    countryModule.config(['foro.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
