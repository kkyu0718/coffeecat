package com.coffeecat.coffeecatbootauth.authservice;

import com.coffeecat.coffeecatdatauser.User;
import org.springframework.stereotype.Service;

@Service
public class GoogleService implements AuthService {
    @Override
    public boolean supports(String socialType) {
        return "GOOGLE".equals(socialType);
    }

    @Override
    public User login(String userIdentifier, String password) {
        return null;
    }

    @Override
    public User signup(String userNickname, String userPassword, String userSocialType) {
        return null;
    }
}
