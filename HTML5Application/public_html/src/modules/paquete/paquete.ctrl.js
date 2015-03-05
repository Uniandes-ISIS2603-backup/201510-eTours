(function () {
	var app = angular.module('paqueteModule');

	app.controller('paqueteCtrl', ['$scope', 'CRUDUtils', 'categoria.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
            
       
})();