package com.app.statistics.exception.advice;

public class IncorrectResultTypeBodyAdviceException extends BaseAdviceException {
    public IncorrectResultTypeBodyAdviceException() {
        super(Functionality.INCORRECT_RESULT_TYPE_BODY);
    }
}