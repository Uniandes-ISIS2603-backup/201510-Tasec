(function () {
    var prizeModule = angular.module('prizeModule', ['CrudModule', 'MockModule']);

    prizeModule.constant('prize.context', 'prizes');

    prizeModule.config(['prize.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
