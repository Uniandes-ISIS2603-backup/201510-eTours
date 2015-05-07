(function () {
	var mocksModule = angular.module('MockModule', ['ngMockE2E']);

	mocksModule.run(['$httpBackend', 'MockModule.urls', function ($httpBackend, urls) {
			function mockUrls(url) {
				var records = [];
				var url_regexp = new RegExp(url + '/([0-9]+)');
				$httpBackend.whenGET(url).respond(function (method, url, data) {
					return [200, records, {}];
				});
				$httpBackend.whenGET(url_regexp).respond(function (method, url, data) {
					var id = url.split('/').pop();
					var record;
					angular.forEach(records, function (value, key) {
						if (value.id == id) {
							record = angular.copy(value);
						}
					});
					return [200, record, {}];
				});
				$httpBackend.whenPOST(url).respond(function (method, url, data) {
					var record = angular.fromJson(data);
					record.id = Math.floor(Math.random() * 10000);
					records.push(record);
					return [200, record, {}];
				});
				$httpBackend.whenPUT(url_regexp).respond(function (method, url, data) {
					var record = angular.fromJson(data);
					angular.forEach(records, function (value, key) {
						if (value.id === record.id) {
							records.splice(key, 1, record);
						}
					});
					return [200, null, {}];
				});
				$httpBackend.whenDELETE(url_regexp).respond(function (method, url, data) {
					var id = url.split('/').pop();
					angular.forEach(records, function (value, key) {
						if (value.id == id) {
							records.splice(key, 1);
						}
					});
					return [200, null, {}];
				});
                                
                                 //Función para indicar a los mock que deben permitir las solicitudes de la URL
             function skipUrl(entity_url) {
                var fullUrl = baseUrl + '/' + entity_url;
                var url_regexp = new RegExp(fullUrl + '/([0-9]+)');
                $httpBackend.whenGET(fullUrl).passThrough();
                $httpBackend.whenGET(url_regexp).passThrough();
                $httpBackend.whenPOST(fullUrl).passThrough();
                $httpBackend.whenPUT(url_regexp).passThrough();
            $httpBackend.whenDELETE(url_regexp).passThrough();
            }
            var ignore_regexp = new RegExp('^((?!' + baseUrl + ').)*$');
            $httpBackend.whenGET(ignore_regexp).passThrough();
                                
                                
                                
				$httpBackend.whenGET(/^((?!webresources).)*$/).passThrough();
			};
			for (var i in urls) {
                        	if (urls.hasOwnProperty(i)) {
                     /*
                     Cuando la URL a registrar tiene el flag de ignorar en true,
                    se llama la función creada para permitir el paso de las solicitudes.
                    De lo contrario se activan los mock para dicha URL.
                    */
                    if (urls[i].skip) {
                         skipUrl(urls[i].url);
                     } else {
                         mockUrls(urls[i].url);
                    }
                                }
                        
                        
                        }
			
		}]);
})();