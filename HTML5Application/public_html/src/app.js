(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'noticiaModule', 'calificacionesModule', 'eventoModule']);
                           
                        
	mainApp.config(['$routeProvider', function ($routeProvider) { 
                        //EJEMPLO CALIFICACION
                        $routeProvider.when('/calificaciones', {
				templateUrl: 'src/modules/calificaciones/calificaciones.tpl.html'
			});
                        $routeProvider.when('/noticia', {
				templateUrl: '../src/modules/evento/evento.tpl.html'
			}).otherwise('/');;
                        
                        $routeProvider.when('/hotel', {
				templateUrl: 'src/modules/hotel/hotel.tpl.html'
                        });
        
                           $routeProvider.when('/paquete', {
				templateUrl: '..src/modules/paquete/paquete.tpl.html'
                        });
        
        
                        $routeProvider.when('/evento', {
				templateUrl: '../src/modules/evento/evento.tpl.html'
                        }).otherwise('/');
                        
		}]);            
            
      
        //EJEMPLO Configuración módulo calificaciones
	var calificacionesModule = angular.module('calificacionesModule', ['CrudModule', 'MockModule']);

	calificacionesModule.constant('calificaciones.context', 'calificaciones');

	calificacionesModule.config(['calificaciones.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            

            
  //Configuración módulo paquete
	var paqueteModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);

	paqueteModule.constant('paquete.context', 'paquete');

	paqueteModule.config(['paquete.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
        //Configuración módulo hotel
	var hotelModule = angular.module('hotelModule', ['CrudModule', 'MockModule']);

	hotelModule.constant('hotel.context', 'hoteles');

	hotelModule.config(['hotel.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();
