/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(){
    var adminModule= angular.module('adminModule',['CrudModule', 'MockModule']);
    
    adminModule.constant('admin.context', 'admins');

    adminModule.config(['admin.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();

