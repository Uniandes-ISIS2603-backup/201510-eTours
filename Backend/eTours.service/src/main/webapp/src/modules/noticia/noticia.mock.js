noticiaModule.constant('noticia.skipMock', true);

   noticiaModule.config(['noticia.context', 'MockModule.urlsProvider','noticia.skipMock', function (context, urlsProvider, skipMock) 
       {         urlsProvider.registerUrl(context, skipMock)
       }]);