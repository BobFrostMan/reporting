package com.app.statistics.exception.advice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseAdviceException extends RuntimeException {
    private Functionality functionality;

    public BaseAdviceException(Functionality functionality) {
        this.functionality = functionality;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
