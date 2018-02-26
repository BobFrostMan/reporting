(function () {
    "use strict"
    angular
        .module("feature")
        .controller("DashboardShow", DashboardShow);

    DashboardShow.$inject = ['dashboardService', 'dashboardManagerService', '$location'];

    function DashboardShow(dashboardService, dashboardManagerService, $location) {
        let $ctrl = this;
        $ctrl.name = "";
        $ctrl.description = "";
        $ctrl.report;
        
        $ctrl.dateFrom = new Date();
        $ctrl.dateTo = new Date();

        function _postConstract() {

            var dashboardName = $location.search().name;

            function onSucces(dashboard) {
                $ctrl.name = dashboard.name;
                $ctrl.description = dashboard.description;

                dashboardManagerService.getDashboardConfig(dashboard, function (report) {
                    $ctrl.report = report;

                });
            }

            function onError(error) {}

            dashboardService.load(dashboardName, onSucces, onError);
          
        }

        _postConstract();
    }
})();
