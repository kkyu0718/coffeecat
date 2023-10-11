package com.coffeecat.coffeecatbootgateway;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static class NoSessionException extends BusinessException {
        public NoSessionException() {
            super(HttpStatus.UNAUTHORIZED, "no session in storage");
        }
    }
}
