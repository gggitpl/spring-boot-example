package com.gggitpl.upload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleAll(final Exception ex, final WebRequest request) {
        final ApiError apiError = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getLocalizedMessage()).errors(Arrays.asList("error occurred"))
                .build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

}
