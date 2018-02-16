package com.app.statistics.exception.advice;

public class IncorrectResultMetaAdviceException extends BaseAdviceException {
    public IncorrectResultMetaAdviceException() {
        super(Functionality.INCORRECT_RESULT_BODY);
    }
}
