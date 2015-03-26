(function () {
	var app = angular.module('noticiaModule');

	app.controller('noticiaCtrl', ['$scope', 'CRUDUtils', 'noticia.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();  
                        
                        this.darTitulo= function(nTitulo)
                                {
                                    titulos = [];
                                    for(var i =0;i< $scope.records.length;i++)
                                    {
                                        var actual = $scope.records[i];
                                        if(actual.titulo===nTitulo)
                                        {
                                           titulos.push(actual);
                                        }
                                    }
                                    $scope.currentRecords=titulos;
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
		}]);
})();
