(function(angular){
    var mod = angular.module('noticiaModule');
    
    mod.service('noticiaService', ['CRUDBase', 'noticia.context', function(base, ctx){
            this.url = ctx;
            base.extendService(this);
            
            this.darPorFecha = function(fecha){
                if (typeof fecha === 'string') {
                    return this.api.customGET('fecha/'+fecha);
                }
            };
    }]);
})(window.angular);