package com.app.statistics.exception.advice;

public class IncorrectResultGroupAdviceException extends BaseAdviceException {
    public IncorrectResultGroupAdviceException() {
        super(Functionality.INCORRECT_RESULT_GROUP);
    }
}
