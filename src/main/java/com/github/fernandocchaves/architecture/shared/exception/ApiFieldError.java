package com.github.fernandocchaves.architecture.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ApiFieldError {

    private String field;
    private String message;
}