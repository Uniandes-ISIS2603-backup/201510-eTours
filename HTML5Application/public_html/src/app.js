(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'sportModule', 'calificacionesModule']);
        

	mainApp.config(['$routeProvider', function ($routeProvider) {   
                        $routeProvider.when('/calificaciones', {
				templateUrl: 'src/modules/calificaciones/calificaciones.tpl.html'
			}).otherwise('/');
                        $routeProvider.when('/noticia', {
				templateUrl: 'src/modules/Noticia/noticia.tpl.html'
			}).otherwise('/');
		}]);            
            
      
        //Configuración módulo calificaciones
	var calificacionesModule = angular.module('calificacionesModule', ['CrudModule', 'MockModule']);

	calificacionesModule.constant('calificaciones.context', 'calificaciones');

	calificacionesModule.config(['calificaciones.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            //Configuración módulo noticia
	var noticiaModule = angular.module('noticiaModule', ['CrudModule', 'MockModule']);

	noticiaModule.constant('noticia.context', 'noticia');

	noticiaModule.config(['noticia.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();