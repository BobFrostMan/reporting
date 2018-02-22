(function () {
    "use strict"
    angular
        .module("commonRoute")
        .config(function ($routeProvider) {
            $routeProvider
                .when("/dashboard", {
                    templateUrl: "resources/app/templates/dashboard-list.htm"
                }).when("/dashboard/show", {
                    templateUrl: "resources/app/templates/show-dashboard.htm"
                }).when("/dashboard/create", {
                    templateUrl: "resources/app/templates/create-dashboard.htm"
                }).when("/result-type", {
                    templateUrl: "resources/app/templates/result-type-list.htm"
                }).when("/result-type/edit", {
                    templateUrl: "resources/app/templates/edit-result-type.htm"
                }).when("/result-type/create", {
                    templateUrl: "resources/app/templates/create-result-type.htm"
                });
        });
})();
