(function(angular){
    var mod = angular.module('servicioModule');
    
    mod.service('servicioService', ['CRUDBase','servicio.context', function(CRUDBase, ctx){
            this.url = ctx;
            CRUDBase.extendService(this);
            this.darServiciosCat = function(){
                return this.api.customGET('categoria');
            };
    }]);
})();