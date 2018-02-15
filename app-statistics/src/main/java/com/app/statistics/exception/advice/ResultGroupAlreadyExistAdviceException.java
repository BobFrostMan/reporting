package com.app.statistics.exception.advice;

public class ResultGroupAlreadyExistAdviceException extends BaseAdviceException {
    public ResultGroupAlreadyExistAdviceException() {
        super(Functionality.RESULT_GROUP_ALREADY_EXIST);
    }
}
