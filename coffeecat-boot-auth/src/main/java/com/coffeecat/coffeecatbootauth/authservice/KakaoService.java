package com.coffeecat.coffeecatbootauth.authservice;

import com.coffeecat.coffeecatdatauser.User;
import org.springframework.stereotype.Service;

@Service
public class KakaoService implements AuthService {
    @Override
    public boolean supports(String socialType) {
        return false;
//        return "KAKAO".equals(socialType);
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
