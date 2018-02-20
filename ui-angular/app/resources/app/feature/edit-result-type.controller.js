(function () {
    "use strict"
    angular
        .module("feature")
        .controller("EditResultType", EditResultType);

    EditResultType.$inject = ['resultTypeService', '$location', "utilService"];

    function EditResultType(resultTypeService, $location, utilService) {
        let $ctrl = this;
        $ctrl.resultType = "{}";
        $ctrl.isError = false;
        $ctrl.editorType = "json-editor";
        $ctrl.updateEditorType = updateEditorType;
        $ctrl.jsonResultTypeExample = "{}";
        $ctrl.saveResultType = saveResultType;
        $ctrl.formatJson = formatJson;

        function _postConstract() {
            loadResultType();
        }
        
        function formatJson() {
            try {
                $ctrl.resultType = utilService.jsonFormat($ctrl.resultType);
            }catch (err) {
                toastr["error"](err.message);
            }  
        }

        function loadResultType() {
            var typeName = $location.search().name;
            if (typeName == undefined || typeName == "") {
                toastr["error"]("Type parameter is absent.");
                $ctrl.resultType = "";
            }

            function onSucces(result) {
                var resultType = _prepareResultType(result.data);
                $ctrl.resultType = utilService.toJsonWithFormat(resultType);
            }

            function onError(error) {
                toastr["error"](_createErrorMessage(error));
            }
            return resultTypeService.find(typeName, onSucces, onError);

        }

        function updateEditorType(value) {
            $ctrl.editorType = value;
        }

        function saveResultType() {
            function onSucces() {
                $location.path('/result-type');
                $location.replace();
            }

            function onError(error) {
                toastr["error"](_createErrorMessage(error));
            }
            resultTypeService.update($ctrl.resultType, onSucces, onError);
        }

        function _createErrorMessage(error) {
            var errorMsg = error.status + " " + error.statusText + ".";
            if (error.data['error_code'] == 7) {
                return errorMsg + " Result type already exists.";
            }

            if (error.data.description != undefined) {
                return errorMsg + " " + error.data.description;
            }
            return errorMsg;
        }

        function _prepareResultType(resultType) {
            var type = resultType;
            delete type.createDate;
            delete type.updateDate;

            utilService.deleteEmptyProperty(type);

            return type;
        }

        _postConstract();
    }
})();
