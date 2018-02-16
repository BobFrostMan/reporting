package com.app.statistics.exception;

public class ResultMappingContainerInitializationException extends RuntimeException {
    public ResultMappingContainerInitializationException() {
    }

    public ResultMappingContainerInitializationException(String message) {
        super(message);
    }

    public ResultMappingContainerInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultMappingContainerInitializationException(Throwable cause) {
        super(cause);
    }

    public ResultMappingContainerInitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
