package com.coffeecat.coffeecatbootauth;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static class UserDuplicatedException extends BusinessException{
        public UserDuplicatedException() {
            super(HttpStatus.CONFLICT, "User Duplicated");
        }
    }

    public static class UserNotFoundException extends BusinessException {
        public UserNotFoundException() {
            super(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public static class WrongPasswordException extends BusinessException {
        public WrongPasswordException() {
            super(HttpStatus.BAD_REQUEST, "Wrong password");
        }
    }

    public static class WrongSocialTypeException extends BusinessException {
        public WrongSocialTypeException() {
            super(HttpStatus.BAD_REQUEST, "Wrong social type");
        }
    }
}
