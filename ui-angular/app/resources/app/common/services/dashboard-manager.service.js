(function () {
    "use strict"
    angular
        .module("commonServices")
        .factory("dashboardManagerService", dashboardManagerService);

    dashboardManagerService.$inject = ['resultService'];

    function dashboardManagerService(resultService) {
        var handlers = {};

        _postConstract();

        return {
            getDashboardConfig
        };

        function _postConstract() {
            handlers['value_diagram'] = valueDiagramHandler;
        }

        function getDashboardConfig(dashboard, callback) {
            var handler = handlers[dashboard.type];
            //ToDo check not null
            handler(dashboard.configuration, callback);
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
            resultService.findAllByType(config.resultType, function (response) {
                var responseList = response.data;
                var result = {chart: {labels: [], data: []}, table: []};
                
                var map = {};
                for (var i = 0; i < responseList.length; i++) {
                    var value = _getValueByFieldName(responseList[i], 'data.' + config.fieldName);
                    if (map.hasOwnProperty(value)) {
                        map[value] = map[value] + 1;
                    } else {
                        map[value] = 1;
                    }
                }
                
                for (var key in map) {
                    var lable = key;
                    var value = map[key];
                    
                    result.chart.labels.push(lable);
                    result.chart.data.push(value);
                    
                    result.table.push({
                        field: lable,
                        count: value
                    });
                }
 
                callback(result);
            });
        };
    }
})();
