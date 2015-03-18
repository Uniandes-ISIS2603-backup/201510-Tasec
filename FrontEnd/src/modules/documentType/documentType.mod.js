(function () {
    var documentTypeModule = angular.module('documentTypeModule', ['CrudModule', 'MockModule']);

    documentTypeModule.constant('documentType.context', 'documentTypes');

    documentTypeModule.config(['documentType.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
