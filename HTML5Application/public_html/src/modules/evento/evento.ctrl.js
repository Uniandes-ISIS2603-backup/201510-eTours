(function () {
	var app = angular.module('eventoModule');
	app.controller('eventoCtrl', ['$scope', 'CRUDUtils', 'evento.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
        
            this.initTimeline = function(){
                $scope.inverted='timeline-inverted';
            }
            this.count = function(){
                if ($scope.inverted==''){
                    $scope.inverted='timeline-inverted';
                }else{
                    $scope.inverted='';
                }
            }
            
		}]);
})();