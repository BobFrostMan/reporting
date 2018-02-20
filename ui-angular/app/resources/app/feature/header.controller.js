(function () {
    "use strict"
    angular
        .module("feature")
        .controller("Header", Header);

    Header.$inject = ["headerService"];
    function Header(headerService) {
        let $ctrl = this;
        $ctrl.headerService = headerService;
    }
})();
