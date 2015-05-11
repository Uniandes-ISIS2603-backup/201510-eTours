(function (ng) {
    var noticiaModule = ng.module('noticiaModule', ['CrudModule']);
    noticiaModule.constant('noticia.context', 'noticia');
})(window.angular);