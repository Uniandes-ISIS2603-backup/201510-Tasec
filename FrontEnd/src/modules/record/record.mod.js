(function () {
    var recordModule = angular.module('recordModule', ['CrudModule', 'MockModule']);

    recordModule.constant('record.context', 'records');

    recordModule.config(['record.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
