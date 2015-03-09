(function () {
	var app = angular.module('servicioModule');

	app.controller('servicioCtrl', ['$scope', 'CRUDUtils', 'servicio.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                        this.fetchRecords();
                        
                                                
		}]);
            
       
})();