(function ()
{
    var paqueteModule = angular.module('paqueteModule', ['CrudModule', 'MockModule']);
paqueteModule.constant('paquete.context', 'paquete');
paqueteModule.constant('paquete.skipMock', true);

   paqueteModule.config(['paquete.context', 'MockModule.urlsProvider','paquete.skipMock', function (context, urlsProvider, skipMock) 
       {         urlsProvider.registerUrl(context, skipMock)
       }]);
   })();