package com.coffeecat.coffeecatbootauth;

import com.coffeecat.coffeecatbootauth.dto.LoginRequestDto;
import com.coffeecat.coffeecatbootauth.dto.LoginResponseDto;
import com.coffeecat.coffeecatbootauth.dto.SignupRequestDto;
import com.coffeecat.coffeecatbootauth.dto.UserResponseDto;
import com.coffeecat.coffeecatdatauser.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto, HttpSession httpSession) {
        User user = authFacadeService.login(dto.getUserIdentifier(), dto.getUserPassword(), dto.getUserSocialType());
        return ResponseEntity.status(HttpStatus.OK).header("token", String.valueOf(user.getUserId())).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto dto) {
        authFacadeService.signup(dto.getUserIdentifier(), dto.getUserPassword(), dto.getUserSocialType());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
