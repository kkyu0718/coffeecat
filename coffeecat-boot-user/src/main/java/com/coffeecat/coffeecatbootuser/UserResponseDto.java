package com.coffeecat.coffeecatbootuser;

import com.coffeecat.coffeecatdatauser.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDto {
    private int userId;
    private String userNickname;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .userNickname(user.getUserNickname())
                .build();
    }
}
