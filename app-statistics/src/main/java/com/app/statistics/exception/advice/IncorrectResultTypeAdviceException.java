package com.app.statistics.exception.advice;

public class IncorrectResultTypeAdviceException extends BaseAdviceException {
    public IncorrectResultTypeAdviceException() {
        super(Functionality.INCORRECT_RESULT_TYPE);
    }
}