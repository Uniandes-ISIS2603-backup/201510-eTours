(function() {
var mainApp = angular.module('mainApp', ['ngRoute', 'ngStorage', 'eventoModule' , 'servicioModule', 'hotelModule', 'noticiaModule', 'paqueteModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) { 
    
        $routeProvider
        .when('/login', {
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
        when('/servicio', {
            templateUrl: '../src/modules/servicio/servicio.tpl.html'
        }).
        when('/noticia', {
            templateUrl: '../src/modules/noticia/noticia.tpl.html'
        }).
        otherwise({
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

    //Configuración módulo servicio
    var servicioModule = angular.module('servicioModule', ['CrudModule', 'MockModule']);
    servicioModule.constant('servicio.context', 'servicios');
    servicioModule.config(['servicio.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);

    //Configuración del módulo hotel
    var hotelModule = angular.module('hotelModule', ['CrudModule', 'MockModule']);
    hotelModule.constant('hotel.context', 'hoteles');
    hotelModule.config(['hotel.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
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
    mainApp.factory("auth", function($location, $localStorage, $window, $timeout)
    {
        return{
            login : function(username, password)
            {
                
                //creamos la cookie con el nombre que nos han pasado
                $localStorage.username = username;
                $localStorage.password = password;
                $localStorage.role = "admin";
                //mandamos a la home
                
                $timeout(function () {
                    $window.location.href = '../../public_html/index.html';
                }, 110);
            },
            logout : function()
            {
                delete $localStorage.username;
                delete $localStorage.password;
                delete $localStorage.role;
                
                $timeout(function () {
                    $window.location.href = '../../public_html/index.html';
                }, 110);
            },
            checkStatus : function()
            {
                //creamos un array con las rutas que queremos controlar
                var rutasPrivadas = ["/login"];
                if(this.in_array($location.path(),rutasPrivadas))
                {
                   if(typeof($localStorage.username) == "undefined")
                    {
                        $location.path("/login");
                    }
                    else
                    {
                        $window.location.href = '../index.html';
                    }
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

    mainApp.controller('loginCtrl', function($scope, auth) 
    {
        //la función login que llamamos en la vista llama a la función
        //login de la factoria auth pasando lo que contiene el campo
        //de texto del formulario
        $scope.login = function()
        {
            auth.login($scope.username, $scope.password);
        }
    });

    mainApp.controller('authStatus', function($scope, $localStorage, auth)
    {
        if($localStorage.username == undefined)
        {
            $scope.loggedIn = false;
            delete $scope.username;
        }
        if($localStorage.username != undefined)
        {
            $scope.loggedIn = true;
            $scope.username = $localStorage.username;
            $scope.userRole = $localStorage.role;
        }
        $scope.logout = function()
        {
            auth.logout();
            console.log($localStorage.username);
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
})();