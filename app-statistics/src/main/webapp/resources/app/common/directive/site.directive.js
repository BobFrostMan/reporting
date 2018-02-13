(function () {
    "use strict"
    angular
        .module("commonDirectives")
        .directive("headerDirective", headerDirective)
        .directive("footerDirective", footerDirective);
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