(function () {
    var hotelModule = angular.module('hotelModule', ['CrudModule', 'MockModule']);

    hotelModule.constant('hotel.context', 'hoteles');

    hotelModule.config(['hotel.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();