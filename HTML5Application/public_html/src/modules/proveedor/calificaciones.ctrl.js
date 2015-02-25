(function () {
	var app = angular.module('calificacionesModule');

	app.controller('calificacionesCtrl', ['$scope', 'CRUDUtils', 'calificaciones.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
                        
                        
		}]);
            
        
})();



 