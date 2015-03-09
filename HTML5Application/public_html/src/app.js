(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'eventoModule','loginModule', 'servicioModule', 'hotelModule', 'noticiaModule', 'paqueteModule']);
        

	mainApp.config(['$routeProvider', function ($routeProvider) { 
    
        $routeProvider
        .when('/servicio', {
            templateUrl: '../src/modules/servicio/servicio.tpl.html'
        }).
        when('/login', {
            templateUrl: '../src/modules/login/login.tpl.html'
        }).
        when('/hotel', {
            templateUrl: '../src/modules/hotel/hotel.tpl.html'
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
       
   
        

    //Configuración modulo login
    var loginModule = angular.module('loginModule', ['CrudModule', 'MockModule']);
    loginModule.constant('login.context', 'login');
    loginModule.config(['login.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
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

    //factoria que controla la autentificación, devuelve un objeto
    //$cookies para crear cookies
    //$cookieStore para actualizar o eliminar
    //$location para cargar otras rutas
    mainApp.factory("auth", function($cookies, $cookieStore, $location, $localStorage, $window)
    {
        return{
            login : function(username, password)
            {
                //creamos la cookie con el nombre que nos han pasado
                $localStorage.username = username;
                $localStorage.password = password;

                //mandamos a la home
                $window.location.href = '../public_html/index.html';
            },
            checkStatus : function()
            {
                console.log($localStorage.username);
                console.log($localStorage.password);
                //creamos un array con las rutas que queremos controlar
                var rutasPrivadas = ["/login"];
                if(this.in_array($location.path(),rutasPrivadas) && typeof($localStorage.username) == "undefined")
                {
                    $location.path("/login");
                }
                //en el caso de que intente acceder al login y ya haya iniciado sesión lo mandamos a la home
                if(this.in_array($location.path(),rutasPrivadas) && typeof($localStorage.username) != "undefined")
                {
                    $window.location.href = '../index.html';
                }
            },
            in_array : function(needle, haystack)
            {
                var key = '';
                for(key in haystack)
                {
                    if(haystack[key] == needle)
                    {
                        return true;
                    }
                }
                return false;
            }
        }
    });

    mainApp.controller('loginCtrl', function($scope,auth) 
    {
        //la función login que llamamos en la vista llama a la función
        //login de la factoria auth pasando lo que contiene el campo
        //de texto del formulario
        $scope.login = function()
        {
            auth.login($scope.username, $scope.password);
        }

    });
    //mientras corre la aplicación, comprobamos si el usuario tiene acceso a la ruta a la que está accediendo
    mainApp.run(function($rootScope, auth)
    {
        //al cambiar de rutas
        $rootScope.$on('$routeChangeStart', function()
        {
            //llamamos a checkStatus, el cual lo hemos definido en la factoria auth
            //la cuál hemos inyectado en la acción run de la aplicación
            auth.checkStatus();
        })
    })
