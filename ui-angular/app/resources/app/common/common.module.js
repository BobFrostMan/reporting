(function () {
    "use strict"
    angular
        .module("common", [
        "ngMaterial", 
        "ngMessages", 
        'ngSanitize',
        //"material.svgAssetsCache",
        'chart.js',
        "commonRoute",
        "commonFilters",
        "commonServices",
        "commonDirectives",
        "commonConstants",
        "commonDecorators"]);
})();