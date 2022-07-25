package com.github.fernandocchaves.architecture.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class RestException extends RuntimeException {

    private final String message;
    private final String key;
    private String[] args;
    private final HttpStatus httpStatus;

    public RestException(String message, String key) {
        this.message = message;
        this.key = key;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public RestException(String message, String key, HttpStatus httpStatus) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
    }
}
