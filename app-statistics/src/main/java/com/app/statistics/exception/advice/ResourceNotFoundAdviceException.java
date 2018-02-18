package com.app.statistics.exception.advice;

public class ResourceNotFoundAdviceException extends BaseAdviceException{
    public ResourceNotFoundAdviceException() {
        super(Functionality.RESOURCE_NOT_FOUND);
    }
}
