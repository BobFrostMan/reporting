function logger($delegate){
    let log = $delegate.log;
    let info = $delegate.info;
    let warn = $delegate.warn;
    let error = $delegate.error;
    let debug = $delegate.debug;
    
    $delegate.log = function(){
        log.apply(null, $wrapLog(arguments));
        return log();
    };
    
    $delegate.info = function(){
        info.apply(null, $wrapLog(arguments));
        return info();
    };
    
    $delegate.warn = function(){
        warn.apply(null, $wrapLog(arguments));
        return warn();
    };
    
    $delegate.error = function(){
        error.apply(null, $wrapLog(arguments));
        return error();
    };
    
    $delegate.debug = function(){
        debug.apply(null, $wrapLog(arguments));
        return debug();
    };
    
    $delegate.myLog = function(){
        log.apply(null, $wrapLogWithMsg("AngularJs Homework", arguments));
        return log();
    };
    
    function $wrapLog(arguments){
        arguments[0] = `${new Date()}. ${arguments[0]}`;
        return arguments;
    }
    
    function $wrapLogWithMsg(msg, arguments){
        arguments = $wrapLog(arguments);
        arguments[0] = `${msg}: ${arguments[0]}`;
        return arguments;
    }
    return $delegate;
}