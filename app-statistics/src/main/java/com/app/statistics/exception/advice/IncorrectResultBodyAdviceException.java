package com.app.statistics.exception.advice;

public class IncorrectResultBodyAdviceException extends BaseAdviceException {
    public IncorrectResultBodyAdviceException() {
        super(Functionality.INCORRECT_RESULT_BODY);
    }
}
