package com.coffeecat.coffeecatbootuser;

public abstract class UserException {
    public static class UserNotFoundException  extends RuntimeException {
        public UserNotFoundException() {
            super("User not found");
        }
    }
}
