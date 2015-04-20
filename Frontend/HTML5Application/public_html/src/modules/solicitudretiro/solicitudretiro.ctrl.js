(function () {
	var miapp = angular.module('retiroModule');
	miapp.controller('retiroCtrl', ['$scope', 'CRUDUtils', 'retiro.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
		}]);
})();