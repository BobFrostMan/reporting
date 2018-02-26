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
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
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
