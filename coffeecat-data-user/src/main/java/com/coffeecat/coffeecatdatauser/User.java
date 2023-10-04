package com.coffeecat.coffeecatdatauser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    private int userId;
    private String userIdentifier;
    private String userPassword;
    private SocialType userSocialType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum SocialType {
        KAKAO, GOOGLE, OAUTH
    }
}
