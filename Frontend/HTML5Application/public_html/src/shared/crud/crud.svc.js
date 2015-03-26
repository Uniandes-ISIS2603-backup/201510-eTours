(function () {
	var crud = angular.module('CrudModule');

	crud.factory('CRUDUtils', ['Restangular', function (RestAngular, $localStorage) {
			function CRUD($scope) {
				this.api = RestAngular.all(this.url);
				$scope.currentRecord = {};
				$scope.records = [];
				this.editMode = false;

				this.fetchRecords = function () {
					var self = this;
					this.api.getList().then(function (data) {
						$scope.records = data;
						$scope.currentRecord = {};
						self.editMode = false;
					});
                                        localStorage.setItem('servicios', JSON.stringify($scope.records));
				};
                              
                                
				this.createRecord = function () {
					this.editMode = true;
					$scope.currentRecord = {};
                                        localStorage.setItem('servicios', JSON.stringify($scope.records));
				};
				this.saveRecord = function () {
					var self = this;
					if ($scope.currentRecord.id) {
						$scope.currentRecord.put().then(function () {
							self.fetchRecords();
						});
					} else {
						this.api.post($scope.currentRecord).then(function () {
							self.fetchRecords();
						});
					}
                                        
                                        localStorage.setItem('servicios', JSON.stringify($scope.records));
				};
				this.deleteRecord = function (record) {
					var self = this;
					record.remove().then(function () {
						self.fetchRecords();
					});
                                        localStorage.setItem('servicios', JSON.stringify($scope.records));
				};
				this.editRecord = function (record) {
					$scope.currentRecord = RestAngular.copy(record);
					this.editMode = true;
                                        localStorage.setItem('servicios', JSON.stringify($scope.records));
				};
			}
			;
			return {
				extendCtrl: function (obj, scope) {
					CRUD.call(obj, scope);
				}
			};
		}]);
})();