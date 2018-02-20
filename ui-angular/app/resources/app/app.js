(function () {
    "use strict"
    angular.module("app", [
        "ngRoute",
        "common",
        "feature"
    ]);
    angular.element(document).ready(function () {
        angular.bootstrap(document, ["app"]);
    });
})();