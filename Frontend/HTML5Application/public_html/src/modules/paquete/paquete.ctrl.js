(function () {
	var app = angular.module('paqueteModule');
	app.controller('paqueteCtrl', ['$scope', 'CRUDUtils', 'paquete.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
            

            
            
paqueteRecords.fetchRecords().then(function(data){
$scope.paqueteRecords = data;
});

             this.armarListaScope = function($scope){
                
var servicios = JSON.parse(servicios);  
for(var i = 0; i < servicios.length; i++ )  
  alert('Servicio: ' + servicios[i].nombre + ' es: ' + servicios[i].tipo);  
                
            };
            
            
            
            
            
            
            
            
   })();   