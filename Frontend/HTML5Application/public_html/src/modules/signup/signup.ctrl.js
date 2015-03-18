(function () {
	var app = angular.module('signupModule');
	app.controller('signupCtrl', ['$scope', 'CRUDUtils', 'signup.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
})();