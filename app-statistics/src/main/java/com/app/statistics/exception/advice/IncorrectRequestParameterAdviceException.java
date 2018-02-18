package com.app.statistics.exception.advice;

public class IncorrectRequestParameterAdviceException extends BaseAdviceException {
    public IncorrectRequestParameterAdviceException() {
        super(Functionality.INCORRECT_REQUEST_PARAMETERS);
    }
}