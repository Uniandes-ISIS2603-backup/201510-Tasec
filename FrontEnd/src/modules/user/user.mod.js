(function () {
    var userModule = angular.module('userModule', ['CrudModule', 'MockModule']);

    userModule.constant('user.context', 'users');

    userModule.config(['user.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
