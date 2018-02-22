(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("dashboardService", dashboardService);

    dashboardService.$inject = [];

    function dashboardService() {
        return {
            load
        }

        function load(dashboardName, onSucces, onError) {

            var mock = {
                "name": "dashboard name",
                "description": "dashboard description",
                "type": "value_diagram",
                "configuration": {
                    "resultType": "DEFAULT",
                    "fieldName": "result"
                }
            };

            onSucces(mock);
        };
    }
})();
