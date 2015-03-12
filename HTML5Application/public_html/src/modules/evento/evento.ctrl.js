(function () {
	var app = angular.module('eventoModule');
	app.controller('eventoCtrl', ['$scope', 'CRUDUtils', 'evento.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
        
            this.initTimeline = function(){
                $scope.inverted='timeline-inverted';
            }
            this.count = function(){
                if ($scope.inverted==''){
                    $scope.inverted='timeline-inverted';
                }else{
                    $scope.inverted='';
                }
            }
            
            this.formatFecha = function(fechaEvento){
                
                var weekday = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
                
                var monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                    "Julio", "Augosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
                
                
                var dia = fechaEvento.getDate();                
                var nombreMes = monthNames[fechaEvento.getMonth()];
                var nombreDia = weekday[fechaEvento.getDay()];
                
                 var fechaString = nombreDia+', '+dia+' de '+nombreMes;
                
                return fechaString;
                
            }
            
		}]);
})();