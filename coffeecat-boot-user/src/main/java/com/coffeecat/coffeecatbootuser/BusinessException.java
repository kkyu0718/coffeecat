package com.coffeecat.coffeecatbootuser;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static class UserNotFoundException  extends BusinessException {
        public UserNotFoundException() {
            super(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
