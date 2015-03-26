(function () {
	var miapp = angular.module('hotelesModule');
	miapp.controller('hotelesCtrl', ['$scope', 'CRUDUtils', 'hotel.context', function ($scope, CRUDUtils, context) {
        this.url = context;
        CRUDUtils.extendCtrl(this, $scope);
        this.fetchRecords();
        
        this.initTimeline = function(){
            $scope.inverted='timeline-inverted';
        }
		}]);
})();