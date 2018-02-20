(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("utilService", utilService);

    utilService.$inject = [];

    function utilService() {
        return {
            jsonFormat, toJsonWithFormat, deleteEmptyProperty, isObject
        };
        
        function jsonFormat(json) {
            var jsonObj = JSON.parse(json);
            return toJsonWithFormat(jsonObj);
        };
        
        function toJsonWithFormat(jsonObj) {
            return JSON.stringify(jsonObj, null, "\t");
        };
        
         function deleteEmptyProperty(obj) {
            var propNames = Object.getOwnPropertyNames(obj);
            for (var i = 0; i < propNames.length; i++) {
                var propName = propNames[i];
                var value = obj[propName];

                if (isObject(value)) {
                    deleteEmptyProperty(value);
                } else if (value === null || value === undefined) {
                    delete obj[propName];
                }
            }

        }

        function isObject(obj) {
            return (typeof obj === "object" && obj !== null) || typeof obj === "function";
        }

    }
})();
