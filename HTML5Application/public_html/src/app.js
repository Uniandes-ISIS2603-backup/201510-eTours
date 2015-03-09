(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'eventoModule', 'servicioModule', 'noticiaModule', 'paqueteModule']);
        

	mainApp.config(['$routeProvider', function ($routeProvider) { 
    
        $routeProvider
        .when('/servicio', {
            templateUrl: '../src/modules/servicio/servicio.tpl.html'
        }).
        when('/paquete', {
            templateUrl: '../src/modules/paquete/paquete.tpl.html'
        }). 
        when('/evento', {
            templateUrl: '../src/modules/evento/evento.tpl.html'
        }).
        when('/noticia', {
            templateUrl: '../src/modules/noticia/noticia.tpl.html'
        }).otherwise({
            redirectTo: '/'
        });
    }]); 

    //Configuración módulo evento
    var eventoModule = angular.module('eventoModule', ['CrudModule', 'MockModule']);
    eventoModule.constant('evento.context', 'eventos');
    eventoModule.config(['evento.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);

    //Configuración del módulo servicio
    var servicioModule = angular.module('servicioModule', ['CrudModule', 'MockModule']);
    servicioModule.constant('servicio.context', 'servicios');
    servicioModule.config(['servicio.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);
    
    //Configuración módulo noticia
    var noticiaModule = angular.module('noticiaModule', ['CrudModule', 'MockModule']);
	noticiaModule.constant('noticia.context', 'noticia');
	noticiaModule.config(['noticia.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);  

    //Configuración módulo paquete
	var paqueteModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);
	paqueteModule.constant('paquete.context', 'paquetes');
	paqueteModule.config(['paquete.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);
})();