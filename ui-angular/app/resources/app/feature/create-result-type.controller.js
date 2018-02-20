(function () {
    "use strict"
    angular
        .module("feature")
        .controller("CreateResultType", CreateResultType);

    CreateResultType.$inject = ['resultTypeService', '$location', 'utilService'];

    function CreateResultType(resultTypeService, $location, utilService) {
        let $ctrl = this;
        $ctrl.resultType = "";
        $ctrl.isError = false;
        $ctrl.editorType = "json-editor";
        $ctrl.updateEditorType = updateEditorType;
        $ctrl.jsonResultTypeExample = getDefaultJsonResultType();
        $ctrl.saveResultType = saveResultType;
        $ctrl.formatJson = formatJson;

        function updateEditorType(value) {
            $ctrl.editorType = value;
        }
        
        function formatJson() {
            try {
                $ctrl.resultType = utilService.jsonFormat($ctrl.resultType);
            }catch (err) {
                toastr["error"](err.message);
            } 
        }

        function saveResultType() {
            function onSucces() {
                $location.path('/result-type');
                $location.replace();
            }

            function onError(error) {
                toastr["error"](_createErrorMessage(error));
            }
            resultTypeService.save($ctrl.resultType, onSucces, onError);
        }

        function getDefaultJsonResultType() {
            var json = '{ "type": "my-test-type", "description": "This is my test type", "fields": [{ "fieldName": "myFieldName", "fieldType": "String", "fieldDescription": "This is my test field" }] }';
            return utilService.jsonFormat(json);
        }

        function _createErrorMessage(error) {
            var errorMsg = error.status + " " + error.statusText + ".";
            if (error.data['error_code'] == 7) {
                return errorMsg + " Result type already exists.";
            }
            
            if(error.data.description != undefined) {
                return errorMsg + " " + error.data.description;
            }
            return errorMsg;
        }
    }
})();
