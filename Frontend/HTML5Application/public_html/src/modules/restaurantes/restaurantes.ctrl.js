(function () {
	var miapp = angular.module('restaurantesModule');
	miapp.controller('restaurantesCtrl', ['$scope', 'CRUDUtils', 'restaurantes.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
        
        this.initTimeline = function(){
            $scope.inverted='timeline-inverted';
        }
        
        this.imageFeatured = function() {
            $scope.featured = 1;
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