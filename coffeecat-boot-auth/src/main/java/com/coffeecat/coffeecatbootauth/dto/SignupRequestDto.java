package com.coffeecat.coffeecatbootauth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String userIdentifier;
    private String userPassword;
    private String userSocialType;
}
