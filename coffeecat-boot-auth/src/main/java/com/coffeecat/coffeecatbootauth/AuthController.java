package com.coffeecat.coffeecatbootauth;

import com.coffeecat.coffeecatbootauth.dto.LoginRequestDto;
import com.coffeecat.coffeecatbootauth.dto.LoginResponseDto;
import com.coffeecat.coffeecatbootauth.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthFacadeService authFacadeService;

    public AuthController(AuthFacadeService authFacadeService) {
        this.authFacadeService = authFacadeService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        authFacadeService.login(dto.getUserIdentifier(), dto.getUserPassword(), dto.getUserSocialType());
//        return LoginResponseDto
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequestDto dto) {
        authFacadeService.signup(dto.getUserIdentifier(), dto.getUserPassword(), dto.getUserSocialType());
    }
}
