package com.coffeecat.coffeecatbootuser;

public abstract class UserException extends RuntimeException {
    protected String message;
    public static class UserNotFoundException extends UserException {
        public UserNotFoundException() {
            this.message = "User Not Found";
        }
    }
}
