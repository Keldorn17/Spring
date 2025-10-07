package com.keldorn.employeerest.controller;

import com.keldorn.employeerest.exception.EmployeeIdNotAllowedException;
import com.keldorn.employeerest.exception.EmployeeNotFoundException;
import com.keldorn.employeerest.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerAdvice {

    private static final String CLIENT_ERROR = "ClientError";

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleException(EmployeeNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .type(CLIENT_ERROR)
                .title(httpStatus.getReasonPhrase())
                .detail(exception.getMessage())
                .statusCode(httpStatus)
                .build();
        return buildResponse(errorResponse);
    }

    @ExceptionHandler(EmployeeIdNotAllowedException.class)
    public ResponseEntity<Object> handleException(EmployeeIdNotAllowedException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .type(CLIENT_ERROR)
                .title(httpStatus.getReasonPhrase())
                .detail(exception.getMessage())
                .statusCode(httpStatus)
                .build();
        return buildResponse(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleException(MethodArgumentTypeMismatchException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        String paramName = exception.getName();
        String providedValue = exception.getValue() != null ? exception.getValue().toString() : "";
        String expectedType = exception.getRequiredType() != null ?
                exception.getRequiredType().getSimpleName() : "unknown";

        return buildResponse(ErrorResponse.builder()
                .type(CLIENT_ERROR)
                .title(httpStatus.getReasonPhrase())
                .detail("Invalid value '%s' for path variable '%s'. Expected a value of type %s."
                        .formatted(providedValue, paramName, expectedType))
                .statusCode(httpStatus)
                .build());
    }

    private ResponseEntity<Object> buildResponse(ErrorResponse errorResponse) {
        return ResponseEntity.status(errorResponse.getStatusCode()).body(errorResponse);
    }
}
