(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'noticiaModule', 'calificacionesModule']);
                           
                        
	mainApp.config(['$routeProvider', function ($routeProvider) { 
                        //EJEMPLO CALIFICACION
                        $routeProvider.when('/calificaciones', {
				templateUrl: 'src/modules/calificaciones/calificaciones.tpl.html'
			}).otherwise('/');
                        $routeProvider.when('/noticia', {
				templateUrl: 'src/modules/noticia/noticia.tpl.html'
			}).otherwise('/');
                        
                        $routeProvider.when('/hotel', {
				templateUrl: 'src/modules/hotel/hotel.tpl.html'
                        }).otherwise('/');
		}]);            
            
      
        //EJEMPLO Configuración módulo calificaciones
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
            
        //Configuración módulo hotel
	var hotelModule = angular.module('hotelModule', ['CrudModule', 'MockModule']);

	hotelModule.constant('hotel.context', 'hoteles');

	hotelModule.config(['hotel.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();
