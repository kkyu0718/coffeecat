package com.coffeecat.coffeecatbootauth;

public abstract class AuthException {

    public static class UserDuplicatedException extends RuntimeException{
        public UserDuplicatedException() {
            super("User Duplicated");
        }
    }

    public static class UserNotFoundByNicknameException extends RuntimeException {
        public UserNotFoundByNicknameException() {
            super("User not found by nickname");
        }
    }

    public static class WrongPasswordException extends RuntimeException {
        public WrongPasswordException() {
            super("Wrong password");
        }
    }
}
