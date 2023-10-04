package com.coffeecat.coffeecatbootauth.authservice;

import com.coffeecat.coffeecatdatauser.User;

public interface AuthService {
    boolean supports(String socialType);
    User login(String userIdentifier, String password);
    User signup(String userNickname, String userPassword, String userSocialType);
}
