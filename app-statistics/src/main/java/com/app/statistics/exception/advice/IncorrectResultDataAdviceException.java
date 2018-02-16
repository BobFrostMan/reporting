package com.app.statistics.exception.advice;

public class IncorrectResultDataAdviceException extends BaseAdviceException {
    public IncorrectResultDataAdviceException() {
        super(Functionality.INCORRECT_RESULT_BODY);
    }
}
