package com.coffeecat.coffeecatbootauth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String userIdentifier;
    private String userPassword;
    private String userSocialType;
}
