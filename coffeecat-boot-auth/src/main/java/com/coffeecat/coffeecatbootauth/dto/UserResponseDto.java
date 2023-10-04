package com.coffeecat.coffeecatbootauth.dto;

import com.coffeecat.coffeecatdatauser.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDto {
    private int userId;
    private String userIdentifier;
    private String socialType;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .userIdentifier(user.getUserIdentifier())
                .socialType(user.getUserSocialType().name())
                .build();
    }
}
