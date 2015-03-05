(function () {
	var app = angular.module('noticiaModule');

	app.controller('noticiaCtrl', ['$scope', 'CRUDUtils', 'noticia.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
})();
