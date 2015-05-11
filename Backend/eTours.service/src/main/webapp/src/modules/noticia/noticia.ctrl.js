(function () {
	var app = angular.module('noticiaModule');

	app.controller('noticiaCtrl', ['$scope', 'CRUDUtils', 'noticia.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
        
			this.fetchRecords();  
        }]);
            
    
    this.formatFecha = function(fechaEvento){
                
                fechaEvento = new Date(fechaEvento);
                
                var weekday = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
                
                var monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                    "Julio", "Augosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
                
               
                              
                              
                              
                              
                var dia = fechaEvento.getDate();                
                var nombreMes = monthNames[fechaEvento.getMonth()];
                var nombreDia = weekday[fechaEvento.getDay()];
                
                 var fechaString = nombreDia+', '+dia+' de '+nombreMes;
                
                return fechaString;
                
            };
               
                        this.darTitulo= function()
                                {
                                    titulos = [];
                                    t=document.getElementById('nTitulo').value;
                            console.log(t);
                                    for(var i =0;i< $scope.records.length;i++)
                                    {
                                        var actual = $scope.records[i];
                                        if(actual.titulo===t)
                                        {
                                           titulos.push(actual);
                                        }
                                    }
                                    $scope.currentRecords=titulos;
                                    this.fetchRecords(); 
                                };
                                
                        this.darFecha= function(nFecha)
                            {
                                    titulos = [];
                                    for(var i =0;i< $scope.records.length;i++)
                                    {
                                        var actual = $scope.records[i];
                                        if(actual.fechaInicial<=nFecha && actual.fechaFinal>=nFecha)
                                        {
                                           titulos.push(actual);
                                        }
                                    }
                                    $scope.currentRecords=titulos;
                            };
	
})();
