(function (ng) 
{
    var servicioModule = ng.module('servicioModule',['CrudModule']);
    servicioModule.constant('servicio.context', 'servicio');
})(window.angular);