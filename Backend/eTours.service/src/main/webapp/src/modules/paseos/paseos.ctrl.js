(function () {
	var miapp = angular.module('paseosModule');
	miapp.controller('paseosCtrl', ['$scope', 'CRUDUtils', 'paseo.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
        
        this.initTimeline = function(){
            $scope.inverted='timeline-inverted';
        }
        
        this.imageFeatured = function() {
            $scope.featured = 1;
        }
        
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
        
        this.changeImageFeatured = function() {
            if($scope.featured == 1) {
                $scope.featured = 2;
            } else if($scope.featured == 2) {
                $scope.featured = 3;
            } else if($scope.featured == 3) {
                $scope.featured = 0;
            } else {
                $scope.featured = 1;
            }
        }
        
		}]);
})();