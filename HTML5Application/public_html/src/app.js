(function () {
	var mainApp = angular.module('mainApp', ['ngRoute', 'noticiaModule', 'calificacionesModule', 'eventoModule']);
                           
                        
	mainApp.config(['$routeProvider', function ($routeProvider) { 
                        $routeProvider.when('/noticia', {
				templateUrl: 'src/modules/noticia/noticia.tpl.html'
			             });
                           $routeProvider.when('/paquete', {
				templateUrl: '..src/modules/paquete/paquete.tpl.html'
                        });
                        $routeProvider.when('/evento', {
				templateUrl: '../src/modules/evento/evento.tpl.html'
                        }).otherwise('/');
                        
		}]);            
            //Configuración módulo noticia
	var noticiaModule = angular.module('noticiaModule', ['CrudModule', 'MockModule']);

	noticiaModule.constant('noticia.context', 'noticia');

	noticiaModule.config(['noticia.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
  //Configuración módulo paquete
	var paqueteModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);

	paqueteModule.constant('paquete.context', 'paquete');

	paqueteModule.config(['paquete.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();