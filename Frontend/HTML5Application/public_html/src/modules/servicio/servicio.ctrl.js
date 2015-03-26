(function () {
	var app = angular.module('servicioModule');
	app.controller('servicioCtrl', ['$scope', 'CRUDUtils', 'servicio.context', function ($scope, CRUDUtils, context, $localStorage) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
        
            this.fetchRecords = function () 
            {
					var self = this;
					this.api.getList().then(function (data) {
						$scope.records = data;
						$scope.currentRecord = {};
						self.editMode = false;
					}); 
                localStorage.setItem('servicios-persistencia', JSON.stringify($scope.records));
                
            };
		}]);
})();