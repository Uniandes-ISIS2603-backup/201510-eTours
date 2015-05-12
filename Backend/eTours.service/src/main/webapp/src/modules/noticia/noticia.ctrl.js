(function (angular) {
    var app = angular.module('noticiaModule');

    app.controller('noticiaCtrl', ['$scope', 'noticiaService', function ($scope, svc) {
            svc.extendCtrl(this, $scope);
            this.fetchRecords();
            
            this.darPorFecha = function(){
                svc.darPorFecha($scope.fecha).then(function(data){
                    $scope.records = data;
                    $scope.totalItems = data.totalRecords;
                    $scope.currentRecord = {}
                    ctrl.editMode = false;
                    return data;
                    
                });
            };
        }]);
})(window.angular);
