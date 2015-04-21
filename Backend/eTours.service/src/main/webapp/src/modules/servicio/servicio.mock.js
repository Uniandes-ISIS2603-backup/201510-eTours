(function () 
{
    var servicioModule = angular.module('servicioModule');
    var idCat;
    servicioModule.run(['$httpBackend', 'servicio.context', 'MockModule.mockRecords', function ($httpBackend, context, mockRecords) 
        {
            $httpBackend.whenGET('webresources/' + context + '/categoria/:'+ idCat).respond(function (idCat) 
            {
                var respuesta;    
                
                
                
                var collection = mockRecords[context];      
                for (var i in collection) 
                {
                    if (collection[i].categoria=='hotel' && idCat==1) 
                    {
                        respuesta.push( collection[i]) ;
                    } else if (collection[i].categoria=='paseo' && idCat==2) 
                    {
                            respuesta.push(collection[i]);
                    } else if (collection[i].categoria=='alimentacion' && idCat==3) 
                    {
                            respuesta.push(collection[i]);
                    }
                }
                return respuesta;
            });

           
        }]);
})();