(function () {
	var app = angular.module('paqueteModule');
	app.controller('paqueteCtrl', ['$scope', 'CRUDUtils', 'paquete.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
            

            //Función para indicar a los mock que deben permitir las solicitudes de la URL  
         function skipUrl(entity_url)
       { 
           var fullUrl = baseUrl + '/' + entity_url;
        var url_regexp = new RegExp(fullUrl + '/([0-9]+)');
       $httpBackend.whenGET(fullUrl).passThrough();
       $httpBackend.whenGET(url_regexp).passThrough(); 
       $httpBackend.whenPOST(fullUrl).passThrough();
       $httpBackend.whenPUT(url_regexp).passThrough(); 
       $httpBackend.whenDELETE(url_regexp).passThrough();
       //hasta aquí
}   


             this.armarListaScope = function($scope){
                
var servicios = JSON.parse(servicios);  
for(var i = 0; i < servicios.length; i++ )  
  alert('Servicio: ' + servicios[i].nombre + ' es: ' + servicios[i].tipo);  
                
            };
            
            
            
            
            
            
            
            
   })();   