package com.github.fernandocchaves.architecture.shared.exception;

import com.github.fernandocchaves.architecture.customer.application.rest.CustomerController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice(basePackageClasses = CustomerController.class)
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleUnexpectedException(HttpServletRequest req, Exception ex) {
        return this.getApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, req);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorMessage handleResourceNotFoundException(HttpServletRequest req, UnauthorizedException ex) {
        return this.getApiError(ex.getMessage(), HttpStatus.NOT_FOUND, req);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ErrorMessage handleUnauthorizedException(HttpServletRequest req, UnauthorizedException ex) {
        return this.getApiError(ex.getMessage(), HttpStatus.UNAUTHORIZED, req);
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected ErrorMessage handleForbiddenException(HttpServletRequest req, ForbiddenException ex) {
        return this.getApiError(ex.getMessage(), HttpStatus.FORBIDDEN, req);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
        List<ApiFieldError> apiFieldErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError ->
                        new ApiFieldError.ApiFieldErrorBuilder()
                                .field(fieldError.getField())
                                .message(fieldError.getDefaultMessage())
                                .build()
                )
                .collect(toList());

        return new ErrorMessage.ErrorMessageBuilder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .path(req.getRequestURI())
                .fieldErrors(apiFieldErrors).build();
    }

    private ErrorMessage getApiError(String message, HttpStatus httpStatus, HttpServletRequest req) {
        return new ErrorMessage.ErrorMessageBuilder()
                .timestamp(LocalDateTime.now())
                .statusCode(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(message)
                .path(req.getRequestURI()).build();
    }
}