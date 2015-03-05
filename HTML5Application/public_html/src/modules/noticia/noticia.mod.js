(function () {
    var noticiaModule = angular.module('noticiaModule', ['CrudModule', 'MockModule']);

    noticiaModule.constant('noticia.context', 'noticias');

    noticiaModule.config(['noticia.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();