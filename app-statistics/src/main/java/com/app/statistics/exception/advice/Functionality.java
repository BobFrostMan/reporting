package com.app.statistics.exception.advice;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Functionality {
    INCORRECT_RESULT_BODY(1, HttpStatus.BAD_REQUEST, "Incorrect result body."),
    INCORRECT_RESULT_TYPE(2, HttpStatus.BAD_REQUEST, "Incorrect result type."),
    RESULT_TYPE_ALREADY_EXIST(3, HttpStatus.BAD_REQUEST, "Result type already exist."),
    INCORRECT_RESULT_GROUP(4, HttpStatus.BAD_REQUEST, "Incorrect result group."),
    RESULT_GROUP_ALREADY_EXIST(5, HttpStatus.BAD_REQUEST, "Result group already exist."),
    REQUEST_MATCHER_NOT_FOUND(6, HttpStatus.BAD_REQUEST, "Request matcher not found."),
    REQUEST_MATCHER_ERROR(7, HttpStatus.INTERNAL_SERVER_ERROR, "Request matcher error."),;

    private static final String ERROR = "ERROR: ";
    private HttpStatus httpStatus;
    private String description;
    private Integer errorCode;

    Functionality(Integer errorCode, HttpStatus httpStatus, String description) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.description = ERROR + description;
    }
}
