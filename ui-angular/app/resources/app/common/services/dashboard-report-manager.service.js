(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("dashboardReportManagerService", dashboardReportManagerService);

    dashboardReportManagerService.$inject = ['resultService'];

    function dashboardReportManagerService(resultService) {
        var handlers = {};

        _postConstract();

        return {
            getReport
        };

        function _postConstract() {
            handlers['value_diagram'] = valueDiagramHandler;
        }

        function getReport(reportConfiguration, callback) {
            var handler = handlers[reportConfiguration.type];
            //ToDo check not null
            handler(reportConfiguration, callback);
        };


        function _getValueByFieldName(data, fieldName) {
            var obj = data;
            var pathToField = fieldName.split(".");

            for (var i = 0; i < pathToField.length; i++) {
                if (obj[pathToField[i]] == undefined) {
                    return null;
                }
                obj = obj[pathToField[i]];
            }
            return obj;
        }



        function valueDiagramHandler(config, callback) {
            //ToDo add error handler
            resultService.findAllByType(config.configuration.resultType, function (response) {
                var reportConfig = config.configuration;
                var responseList = response.data;

                var result = {};
                result.name = config.name;
                result.description = config.description;
                result.source = {};
                result.source.labels = [];
                result.source.data = [];


                var map = {};
                for (var i = 0; i < responseList.length; i++) {
                    var value = _getValueByFieldName(responseList[i], 'data.' + reportConfig.fieldName);
                    if (map.hasOwnProperty(value)) {
                        map[value] = map[value] + 1;
                    } else {
                        map[value] = 1;
                    }
                }

                for (var key in map) {
                    result.source.labels.push(key);
                    result.source.data.push(map[key]);
                }
 
                callback(result);
            });
        };
    }
})();
