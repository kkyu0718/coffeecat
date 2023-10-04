package com.coffeecat.coffeecatbootauth;

import com.coffeecat.coffeecatbootauth.authservice.AuthService;
import com.coffeecat.coffeecatbootauth.authservice.GoogleService;
import com.coffeecat.coffeecatbootauth.authservice.KakaoService;
import com.coffeecat.coffeecatbootauth.authservice.OAuthService;
import com.coffeecat.coffeecatbootauth.dto.LoginResponseDto;
import com.coffeecat.coffeecatbootauth.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthFacadeService {
    private final OAuthService oAuthService;
    private final KakaoService kakaoService;
    private final GoogleService googleService;

    public AuthFacadeService(OAuthService OAuthService, KakaoService kakaoService, GoogleService googleService) {
        this.oAuthService = OAuthService;
        this.kakaoService = kakaoService;
        this.googleService = googleService;
    }

    public LoginResponseDto login(String userIdentifier, String userPassword, String userSocialType) {
        AuthService authService = authServiceFactory(userSocialType);

        // authentication by redis session
        // give token

    }

    public UserResponseDto signup(String userIdentifier, String userPassword, String userSocialType) {
        AuthService authService = authServiceFactory(userSocialType);

        return UserResponseDto.fromEntity(authService.signup(userIdentifier, userPassword, userSocialType));
    }

    private AuthService authServiceFactory(String socialType) {
        return List.of(oAuthService, kakaoService, googleService).stream()
                .filter(service -> service.supports(socialType))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
