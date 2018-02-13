package com.app.statistics.exception;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super(Functionality.USER_NOT_FOUND);
    }
}
