package com.coffeecat.coffeecatdatauser;

public class UserException extends RuntimeException {
    public static class UserNotFoundException extends UserException {
        private String message;
        public UserNotFoundException() {
            this.message = "User Not Found";
        }
    }
}
