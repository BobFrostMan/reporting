(function () {
    "use strict"
    angular
        .module("commonFilters")
        .filter('unsafe', unsafe);

    unsafe.$inject = ['$sce'];

    function unsafe($sce) {
        return $sce.trustAsHtml;
    }
})();
