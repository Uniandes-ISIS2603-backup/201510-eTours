(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'sportModule', 'calificacionesModule']);
        

	mainApp.config(['$routeProvider', function ($routeProvider) {
			$routeProvider.when('/sport', {
				templateUrl: 'src/modules/sport/sport.tpl.html'
			}).otherwise('/');
                        
                        $routeProvider.when('/hotel', {
				templateUrl: 'src/modules/hotel/hotel.tpl.html'
			}).otherwise('/');
		}]);            
            
      


	//Configuración módulo sport
	var sportModule = angular.module('sportModule', ['CrudModule', 'MockModule']);

	sportModule.constant('sport.context', 'sports');

	sportModule.config(['sport.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
        //Configuración módulo calificaciones
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