(function () {
    "use strict"
    angular
        .module("commonDecorators", [])
        .config(decoration);
    
    function decoration($provide){
        $provide.decorator("$log", logger);
    };

})();