(function () {
	var mainApp = angular.module('mainApp', ['ngRoute', 'noticiaModule', 'calificacionesModule', 'eventoModule','paqueteModule']);         

	mainApp.config(['$routeProvider', function ($routeProvider) { 
        
        $routeProvider.when('/hotel', {templateUrl: 'src/modules/hotel/hotel.tpl.html'}).otherwise('/');
        
        $routeProvider.when('/paquete', {templateUrl: '../src/modules/paquete/paquete.tpl.html'}).otherwise('/');
        
        $routeProvider.when('/evento', { templateUrl: '../src/modules/evento/evento.tpl.html'}).otherwise('/');
        
        $routeProvider.when('/noticia', {templateUrl: '../src/modules/noticia/noticia.tpl.html'}).otherwise('/');
    }]);            
    
    //Configuración módulo noticia
    var noticiaModule = angular.module('noticiaModule', ['CrudModule', 'MockModule']);
	noticiaModule.constant('noticia.context', 'noticia');
	noticiaModule.config(['noticia.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);  
    
    //Configuración módulo evento
    var eventoModule = angular.module('eventoModule', ['CrudModule', 'MockModule']);
    eventoModule.constant('evento.context', 'eventos');
    eventoModule.config(['evento.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);
        
  //Configuración módulo paquete
	var paqueteModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);
	paqueteModule.constant('paquete.context', 'paquetes');
	paqueteModule.config(['paquete.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);
})();
