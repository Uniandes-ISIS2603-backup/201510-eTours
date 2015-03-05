(function () {
    var eventoModule = angular.module('eventoModule', ['CrudModule', 'MockModule']);

    eventoModule.constant('evento.context', 'eventos');

    eventoModule.config(['evento.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();