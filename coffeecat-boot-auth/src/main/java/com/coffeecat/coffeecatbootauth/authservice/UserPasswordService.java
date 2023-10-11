package com.coffeecat.coffeecatbootauth.authservice;

import com.coffeecat.coffeecatbootauth.BusinessException;
import com.coffeecat.coffeecatdatauser.User;
import com.coffeecat.coffeecatdatauser.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Slf4j
public class UserPasswordService implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserPasswordService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(String socialType) {
        return "USERPASSWORD".equals(socialType);
    }

    @Override
    public User login(String userIdentifier, String password) {
        // find user from db
        User user = userService.findUserByUserIdentifier(userIdentifier).orElseThrow(BusinessException.UserNotFoundException::new);

        if(!checkPassword(password, user.getUserPassword())) {
            throw new BusinessException.WrongPasswordException();
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
        if(userService.findUserByUserIdentifier(userIdentifier).isPresent()){
            throw new BusinessException.UserDuplicatedException();
        }

        return userService.createUser(userIdentifier, passwordEncoder.encode(userPassword), userSocialType);
    }
}
