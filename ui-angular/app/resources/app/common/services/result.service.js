(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("resultService", resultService);

    resultService.$inject = ["$http"];

    function resultService($http) {
        var serverUrl = "http://localhost:8090";
        
        return {
            findAll, findAllByType
        };

        function findAll(succesCallback, errorCallback) {
            $http.get(serverUrl + "/api/result").then(succesCallback, errorCallback);
        };
        
        function findAllByType(type, succesCallback, errorCallback) {
            $http.get(serverUrl + "/api/result/" + type).then(succesCallback, errorCallback);
        };
    }
})();
