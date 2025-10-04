package com.keldorn.section_4.controller;

import com.keldorn.section_4.exception.StudentNotFoundException;
import com.keldorn.section_4.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    private static final String CLIENT_ERROR = "ClientError";

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleException(StudentNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(httpStatus)
                .type(CLIENT_ERROR)
                .title(httpStatus.getReasonPhrase())
                .detail(exception.getMessage())
                .build();
        return buildResponse(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleException(MethodArgumentTypeMismatchException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        String paramName = exception.getName();
        String providedValue = exception.getValue() != null ? exception.getValue().toString() : "null";
        String expectedType = exception.getRequiredType() != null ?
                exception.getRequiredType().getSimpleName() : "unknown";

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(httpStatus)
                .type(CLIENT_ERROR)
                .title(httpStatus.getReasonPhrase())
                .detail("Invalid value '%s' for path variable '%s'. Expected a value of type %s."
                        .formatted(providedValue, paramName, expectedType))
                .build();
        return buildResponse(errorResponse);
    }

    private ResponseEntity<Object> buildResponse(ErrorResponse errorResponse) {
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
//        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
