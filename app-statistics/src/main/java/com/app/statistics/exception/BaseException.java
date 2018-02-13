package com.app.statistics.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseException extends RuntimeException {
    private Functionality functionality;

    public BaseException(Functionality functionality) {
        this.functionality = functionality;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
