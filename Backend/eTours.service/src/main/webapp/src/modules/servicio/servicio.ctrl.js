(function (angular) {
    var app = angular.module('servicioModule');
   
    app.controller('servicioCtrl', ['$scope','servicioService', function ($scope, svc) {
            svc.extendCtrl(this, $scope);
            this.fetchRecords();

            this.darServicio = function (){
                svc.darServicio($scope.fecha).then(function(data){
                    $scope.records = data;
                    $scope.totalItems = data.totalRecords;
                    $scope.currentRecord = {}
                    ctrl.editMode = false;
                    return data;
                    
                });

            };
        }]);
})(window.angular);
