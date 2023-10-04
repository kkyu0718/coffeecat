package com.coffeecat.coffeecatbootauth.authservice;

import com.coffeecat.coffeecatbootauth.AuthException;
import com.coffeecat.coffeecatdatauser.User;
import com.coffeecat.coffeecatdatauser.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OAuthService implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public OAuthService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(String socialType) {
        return "OAUTH".equals(socialType);
    }

    @Override
    public User login(String userIdentifier, String password) {
        // find user from db
        User user = userService.findUserByUserIdentifier(userIdentifier).orElseThrow(AuthException.UserNotFoundByNicknameException::new);

        if(!checkPassword(password, user.getUserPassword())) {
            throw new AuthException.WrongPasswordException();
        }
        return user;
    }

    private boolean checkPassword(String password, String encodedPassword) {
        // compare password
        Function<String, Boolean> matches = (s) -> passwordEncoder.matches(s, encodedPassword);
        return matches.apply(password);
    }

    @Override
    public User signup(String userIdentifier, String userPassword, String userSocialType) {
        userService.findUserByUserIdentifier(userIdentifier).orElseThrow(AuthException.UserDuplicatedException::new);

        return userService.createUser(userIdentifier, passwordEncoder.encode(userPassword), userSocialType);
    }
}
