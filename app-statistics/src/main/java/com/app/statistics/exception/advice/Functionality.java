package com.app.statistics.exception.advice;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Functionality {
    INCORRECT_RESULT_BODY(1, HttpStatus.BAD_REQUEST, "Incorrect result body."),
    INCORRECT_RESULT_TYPE(2, HttpStatus.BAD_REQUEST, "Incorrect result meta."),
    INCORRECT_RESULT_DATA(3, HttpStatus.BAD_REQUEST, "Incorrect result data."),
    INCORRECT_RESULT_GROUP(4, HttpStatus.BAD_REQUEST, "Incorrect result group."),
    REQUEST_MATCHER_ERROR(5, HttpStatus.INTERNAL_SERVER_ERROR, "Request matcher error."),
    INCORRECT_RESULT_TYPE_BODY(6, HttpStatus.BAD_REQUEST, "Incorrect result type body."),
    RESOURCE_ALREADY_EXISTS(7, HttpStatus.CONFLICT, "Resource already exists."),
    RESOURCE_NOT_FOUND(8, HttpStatus.NOT_FOUND, "Resource not found."),
    INCORRECT_REQUEST_PARAMETERS(9, HttpStatus.BAD_REQUEST, "Incorrect request parameters.");

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
