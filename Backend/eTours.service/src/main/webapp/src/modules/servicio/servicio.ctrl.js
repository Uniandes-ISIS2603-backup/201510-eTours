(function (angular) {
    var app = angular.module('servicioModule');
    app.controller('servicioCtrl', ['$scope','servicioService', function ($scope, svc) {
            this.url = context;
            svc.extendCtrl(this, $scope);
            this.fetchRecords();

            this.fetchRecords = function ()
            {
                var self = this;
                this.api.getList().then(function (data) {
                    $scope.records = data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                });

            };
        }]);
})(window.angular);
