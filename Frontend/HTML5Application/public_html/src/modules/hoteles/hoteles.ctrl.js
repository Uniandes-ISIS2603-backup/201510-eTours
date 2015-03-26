(function () {
	var miapp = angular.module('hotelesModule');
	miapp.controller('hotelesCtrl', ['$scope', 'CRUDUtils', 'hotel.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
        
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
        
        this.initTimeline = function(){
            $scope.inverted='timeline-inverted';
        }
        
		}]);
})();