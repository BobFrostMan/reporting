package com.app.statistics.exception.advice;

public class RequestMatcherAdviceException extends BaseAdviceException {
    public RequestMatcherAdviceException() {
        super(Functionality.REQUEST_MATCHER_ERROR);
    }
}
