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
            function skipUrl(entity_url)
       { 
           var fullUrl = baseUrl + '/' + entity_url;
        var url_regexp = new RegExp(fullUrl + '/([0-9]+)');
       $httpBackend.whenGET(fullUrl).passThrough();
       $httpBackend.whenGET(url_regexp).passThrough(); 
       $httpBackend.whenPOST(fullUrl).passThrough();
       $httpBackend.whenPUT(url_regexp).passThrough(); 
       $httpBackend.whenDELETE(url_regexp).passThrough();
       //hasta aquí
}   
            
		}]);
})();