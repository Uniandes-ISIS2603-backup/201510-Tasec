(function () {
    var refereeModule = angular.module('refereeModule', ['CrudModule', 'MockModule']);

    refereeModule.constant('referee.context', 'referees');

    refereeModule.config(['referee.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
