package com.github.fernandocchaves.architecture.shared.exception;

public class ForbiddenException extends Exception {
    public ForbiddenException() {
        super("Forbidden!");
    }
}