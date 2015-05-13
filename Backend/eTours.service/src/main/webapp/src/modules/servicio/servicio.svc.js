(function(angular){
    var mod = angular.module('servicioModule');
    
    mod.service('servicioService', ['CRUDBase','servicio.context', function(bse, ctx){
            this.url = ctx;
            bse.extendService(this);
            this.darServiciosCat = function(categoria){
                return this.api.customGET('categoria'+ categoria);
            };
    }]);
})(window.angular);