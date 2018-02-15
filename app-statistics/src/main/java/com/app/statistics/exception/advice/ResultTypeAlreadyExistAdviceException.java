package com.app.statistics.exception.advice;

public class ResultTypeAlreadyExistAdviceException extends BaseAdviceException {
    public ResultTypeAlreadyExistAdviceException() {
        super(Functionality.RESULT_TYPE_ALREADY_EXIST);
    }
}
