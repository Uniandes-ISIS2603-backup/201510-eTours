(function () 
{
var mocksModule = angular.module('paqueteModule', ['paqueteCtrl']);

	mocksModule.run(['$httpBackend', 'MockModule.urls', function ($httpBackend, urls) {
			function mockUrls(url) {
				var records = [];
				var url_regexp = new RegExp(url + '/([0-9]+)');
				$httpBackend.whenGET(url).respond(function (method, url, data) {
					return [paqueteCtrl.JSON];
				


})();