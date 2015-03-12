(function () {
    var addressModule = angular.module('addressModule', ['CrudModule', 'MockModule']);

    addressModule.constant('address.context', 'addresss');

    addressModule.config(['address.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
