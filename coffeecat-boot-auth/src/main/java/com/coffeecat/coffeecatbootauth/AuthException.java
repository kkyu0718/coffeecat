package com.coffeecat.coffeecatbootauth;

public abstract class AuthException extends RuntimeException {
    protected String message;

    public static class UserDuplicatedException extends AuthException {
        public UserDuplicatedException() {
            this.message = "User Duplicated";
        }
    }

    public static class UserNotFoundByNicknameException extends AuthException {
        public UserNotFoundByNicknameException() {
            this.message = "User not found by nickname";
        }
    }

    public static class WrongPasswordException extends AuthException {
        public WrongPasswordException() {
            this.message = "Wrong password";
        }
    }
}
