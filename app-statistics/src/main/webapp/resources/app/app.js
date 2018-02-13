(function () {
    "use strict"
    angular.module("app", [
        "common",
        "feature"
    ]);
    angular.element(document).ready(function () {
        angular.bootstrap(document, ["app"]);
    });
})();