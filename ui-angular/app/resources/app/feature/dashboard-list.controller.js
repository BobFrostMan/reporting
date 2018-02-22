(function () {
    "use strict"
    angular
        .module("feature")
        .controller("DashboardList", DashboardList);

    DashboardList.$inject = [];

    function DashboardList() {
        let $ctrl = this;
        $ctrl.reloadTypes = reloadTypes;
        
        function _postConstract() {
        }
        
        function reloadTypes() {
            
        }
        
        _postConstract();
    }
})();
