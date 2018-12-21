package com.gggitpl.upload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileStorageNotFoundException extends RuntimeException {

    public FileStorageNotFoundException(final String message) {
        super(message);
    }

    public FileStorageNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
