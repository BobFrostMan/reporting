package com.app.statistics.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Functionality {
    USER_NOT_FOUND(1, HttpStatus.BAD_REQUEST, "UserEntity not found.");

    private HttpStatus httpStatus;
    private String description;
    private Integer errorCode;

    Functionality(Integer errorCode, HttpStatus httpStatus, String description) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
