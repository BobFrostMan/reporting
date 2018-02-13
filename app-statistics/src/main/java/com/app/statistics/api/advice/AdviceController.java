package com.app.statistics.api.advice;

import com.app.statistics.exception.BaseException;
import com.app.statistics.exception.Functionality;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@EnableWebMvc
public class AdviceController {
    private static final String ERROR_CODE_PROPERTY = "error_code";
    private static final String DESCRIPTION_PROPERTY = "description";
    private static final String HTTP_STATUS_PROPERTY = "http_status";

    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(final BaseException ex) {
        final Functionality functionality = ex.getFunctionality();

        final Map<String,Object> errorInfo = new HashMap<>();
        errorInfo.put(ERROR_CODE_PROPERTY, functionality.getErrorCode());
        errorInfo.put(DESCRIPTION_PROPERTY, functionality.getDescription());
        errorInfo.put(HTTP_STATUS_PROPERTY, functionality.getHttpStatus());

        return new ResponseEntity<>(errorInfo, functionality.getHttpStatus());
    }
}