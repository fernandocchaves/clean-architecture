package com.github.fernandocchaves.architecture.shared.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RestException {

    private static final String MESSAGE = "Resource not found";

    public ResourceNotFoundException() {
        super(MESSAGE, "error.resource.not.found", HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String key) {
        super(MESSAGE, key, HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String[] args) {
        super(MESSAGE, "error.resource.not.found", args, HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String key, String[] args) {
        super(MESSAGE, key, args, HttpStatus.NOT_FOUND);
    }
}
