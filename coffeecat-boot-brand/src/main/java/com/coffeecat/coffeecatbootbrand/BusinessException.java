package com.coffeecat.coffeecatbootbrand;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static class BrandNotFoundException extends BusinessException {

        public BrandNotFoundException() {
            super(HttpStatus.NOT_FOUND, "brand not found");
        }
    }

    public static class CapsuleNotFoundException extends BusinessException {

        public CapsuleNotFoundException() {
            super(HttpStatus.NOT_FOUND, "capsule not found");
        }
    }

    public static class TagNotFoundException extends BusinessException {

        public TagNotFoundException() {
            super(HttpStatus.NOT_FOUND, "tag not found");
        }
    }
}
