package com.coffeecat.coffeecatbootauth;

import com.coffeecat.coffeecatbootauth.authservice.AuthService;
import com.coffeecat.coffeecatbootauth.authservice.GoogleService;
import com.coffeecat.coffeecatbootauth.authservice.KakaoService;
import com.coffeecat.coffeecatbootauth.authservice.UserPasswordService;
import com.coffeecat.coffeecatdatauser.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.coffeecat.coffeecatbootauth.BusinessException.*;

@Service
@Slf4j
public class AuthFacadeService {
    private final UserPasswordService userPasswordService;
    private final KakaoService kakaoService;
    private final GoogleService googleService;

    public AuthFacadeService(UserPasswordService UserPasswordService, KakaoService kakaoService, GoogleService googleService) {
        this.userPasswordService = UserPasswordService;
        this.kakaoService = kakaoService;
        this.googleService = googleService;
    }

    public User login(String userIdentifier, String userPassword, String userSocialType) {
        AuthService authService = authServiceFactory(userSocialType);
        log.info("[AuthFacadeService] login {}", authService);

        return authService.login(userIdentifier, userPassword);
    }

    @Transactional
    public User signup(String userIdentifier, String userPassword, String userSocialType) {
        AuthService authService = authServiceFactory(userSocialType);
        log.info("[AuthFacadeService] signup {}", authService);

        return authService.signup(userIdentifier, userPassword, userSocialType);
    }

    private AuthService authServiceFactory(String socialType) {
        return List.of(userPasswordService, kakaoService, googleService).stream()
                .filter(service -> service.supports(socialType))
                .findAny()
                .orElseThrow(WrongSocialTypeException::new);
    }
}
