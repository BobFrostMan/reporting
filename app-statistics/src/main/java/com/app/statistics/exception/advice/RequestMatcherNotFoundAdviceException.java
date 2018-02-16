package com.app.statistics.exception.advice;

public class RequestMatcherNotFoundAdviceException extends BaseAdviceException {
    public RequestMatcherNotFoundAdviceException() {
        super(Functionality.REQUEST_MATCHER_NOT_FOUND);
    }
}
