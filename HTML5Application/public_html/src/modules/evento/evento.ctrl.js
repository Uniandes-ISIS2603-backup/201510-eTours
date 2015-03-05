(function () {
	var app = angular.module('eventoModule');

	app.controller('eventoCtrl', ['$scope', 'CRUDUtils', 'evento.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
                        this.showMost = false;
                        this.mostPopulated = function (){
                            this.showMost = true;
                            $scope.mostPopulated = "Ninguno";
                            var actual = 0;
                            angular.forEach($scope.records, function (record){
                                if(record.poblacion > actual){
                                    actual = record.poblacion;
                                    $scope.mostPopulated = record.name; 
                                }
                            });
//                            
                        };
                        
		}]);
})();