(function () {
    "use strict"
    angular
        .module("commonDirectives")
        .directive("headerDirective", headerDirective)
        .directive("footerDirective", footerDirective)
        .directive("resultTypeEditorDirective", resultTypeEditorDirective)
        .directive("resultTypeJsonEditorDirective", resultTypeJsonEditorDirective)
        .directive("resultTypeUiEditorDirective", resultTypeUiEditorDirective);
})();

function headerDirective(){
    return {
        restrict: "EA"
        , templateUrl: "resources/app/templates/header.htm"
    }
}

function footerDirective(){
    return {
        restrict: "EA"
        , templateUrl: "resources/app/templates/footer.htm"
    }
}

function resultTypeEditorDirective(){
    return {
        restrict: "EA"
        , templateUrl: "resources/app/templates/result-type-editor.htm"
    }
}

function resultTypeJsonEditorDirective(){
    return {
        restrict: "EA"
        , templateUrl: "resources/app/templates/result-type-json-editor.htm"
    }
}

function resultTypeUiEditorDirective(){
    return {
        restrict: "EA"
        , templateUrl: "resources/app/templates/result-type-ui-editor.htm"
    }
}