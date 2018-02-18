package com.app.statistics.exception.advice;

public class ResourceAlreadyExistsAdviceException extends BaseAdviceException{
    public ResourceAlreadyExistsAdviceException() {
        super(Functionality.RESOURCE_ALREADY_EXISTS);
    }
}
