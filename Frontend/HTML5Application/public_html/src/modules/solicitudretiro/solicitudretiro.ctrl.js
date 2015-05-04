(function () {
	var miapp = angular.module('solicitudRetiroModule');
	miapp.controller('retiroCtrl', ['$scope', 'CRUDUtils', 'solicitudRetiro.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
		}]);
})();