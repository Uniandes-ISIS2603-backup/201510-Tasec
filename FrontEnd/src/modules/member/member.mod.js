(function () {
    var memberModule = angular.module('memberModule', ['CrudModule', 'MockModule']);

    memberModule.constant('member.context', 'members');

    memberModule.config(['member.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();
