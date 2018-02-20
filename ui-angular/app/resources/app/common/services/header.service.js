(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("headerService", headerService);

    headerService.$inject = ['$location'];
    function headerService($location) {
        return {isCurrentPage};

        function isCurrentPage(name) {
            var urlPagePath = $location.path().trim().toLowerCase();
            var pageName = name.trim().toLowerCase();
            return urlPagePath.indexOf(pageName) > -1;
        };
    }
})();