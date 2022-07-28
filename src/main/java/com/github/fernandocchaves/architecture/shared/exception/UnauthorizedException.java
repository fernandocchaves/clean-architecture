package com.github.fernandocchaves.architecture.shared.exception;

public class UnauthorizedException extends Exception {
    public UnauthorizedException() {
        super("Unauthorized!");
    }
}