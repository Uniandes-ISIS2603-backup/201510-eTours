(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'sportModule', 'calificacionesModule']);
        

	mainApp.config(['$routeProvider', function ($routeProvider) {
			$routeProvider.when('/sport', {
				templateUrl: 'src/modules/sport/sport.tpl.html'
			}).otherwise('/');
                        
                        $routeProvider.when('/hotel', {
				templateUrl: 'src/modules/hotel/hotel.tpl.html'
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
            
            //Configuración módulo categoria
	var calificacionesModule = angular.module('calificacionesModule', ['CrudModule', 'MockModule']);

	calificacionesModule.constant('calificaciones.context', 'calificaciones');

	calificacionesModule.config(['calificaciones.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
        //Configuración módulo hotel
	var hotelModule = angular.module('hotelModule', ['CrudModule', 'MockModule']);

	sportModule.constant('hotel.context', 'hoteles');

	sportModule.config(['hotel.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();
