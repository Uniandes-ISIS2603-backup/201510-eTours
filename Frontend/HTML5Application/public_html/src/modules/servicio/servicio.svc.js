(function(){
    var servicioModule = angular.module('servicioModule');
    
    servicioModule.service('servicioService', ['CRUDBase','servicio.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
            this.darServiciosCat = function(){
                return this.api.customGET('categoria');
            };
    }]);
})();