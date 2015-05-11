(function () {
	var mock = angular.module('MockModule');
     
        mock.value('MockModule.mockRecords', {});
	mock.provider('MockModule.urls', function () {
		var context = [];
		this.registerUrl = function (value) {
			context.push('webresources/' + value);
		};
                
                // activa el flag que permite saltar la url por parte del mock(dejarla pasar al backend con true)
                 this.registerUrl = function (value, skip) {
             context.push({url: value, skip: !!skip});
         };
                
		this.$get = function () {
			return context;
		};
                
	});
})();