(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("resultTypeService", resultTypeService);

    resultTypeService.$inject = ["$http"];

    function resultTypeService($http) {
        var serverUrl = "http://localhost:8090";
        return {
            find,
            findAll,
            deleteByType,
            save,
            update
        };
        
        function find(typeName, succesCallback, errorCallback) {
            $http.get(serverUrl + "/api/result-type/ " + typeName).then(succesCallback, errorCallback);
        };

        function findAll(succesCallback, errorCallback) {
            $http.get(serverUrl + "/api/result-type").then(succesCallback, errorCallback);
        };
        
        function save(resultType, succesCallback, errorCallback) {
            $http.post(serverUrl + "/api/result-type", resultType).then(succesCallback, errorCallback);
        };
        
        function update(resultType, succesCallback, errorCallback) {
            $http.put(serverUrl + "/api/result-type", resultType).then(succesCallback, errorCallback);
        };

        function deleteByType(typeName, succesCallback, errorCallback) {
            $http.delete(serverUrl + "/api/result-type/" + typeName).then(succesCallback, errorCallback);
        };
    }
})();
