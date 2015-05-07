noticiaModule.constant('noticia.skipMock', true);
noticiaModule.constant('noticia.context', 'not');

   noticiaModule.config(['noticia.context', 'MockModule.urlsProvider','noticia.skipMock', function (context, urlsProvider, skipMock) 
       {         urlsProvider.registerUrl(context, skipMock)
       }]);
   
   countryModule.run(['$httpBackend', 'noticia.context', 'MockModule.mockRecords', 'noticia.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock) {
                $httpBackend.whenGET(baseUrl + '/' + context + '/darNoticia').passThrough();
            }
        }]);