(function () {
    "use strict"
    angular
        .module("feature")
        .controller("ResultTypeList", ResultTypeList);

    ResultTypeList.$inject = ["resultTypeService"];

    function ResultTypeList(resultTypeService) {
        let $ctrl = this;
        $ctrl.resultTypes = [];
        $ctrl.deleteByType = deleteByType;
        $ctrl.reloadTypes = reloadTypes;
        
        function _postConstract() {
            loadResultType();
        }
        
        function reloadTypes() {            
            loadResultType();
        }
        
        function loadResultType() {
            function onSucces(result) {
                $ctrl.resultTypes = result.data;
            }

            function onError(data) {
                toastr["error"](data.status + " " + data.data.description);
            }
            resultTypeService.findAll(onSucces, onError);
        }

        function deleteByType(type) {
            function onSucces() {
                deleteTypeFormList(type, $ctrl.resultTypes);
            }

            function onError(data) {
                toastr["error"](data.status + " " + data.data.description);
            }
            resultTypeService.deleteByType(type, onSucces, onError);
        }
        
        _postConstract();
    }

    function deleteTypeFormList(type, list) {
        var index = indexOfType(type, list);
        if (index > -1) {
            list.splice(index, 1);
        }
    }

    function indexOfType(type, list) {
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            if (item.type == type) {
                return i;
            }
        }
        return -1;
    }
})();
