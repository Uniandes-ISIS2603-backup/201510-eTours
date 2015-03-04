(function () {
	var app = angular.module('categoriaModule');

	app.controller('sportCtrl', ['$scope', 'CRUDUtils', 'categoria.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
            
       
})();