package com.coffeecat.coffeecatdatauser;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(int userId);
    Optional<User> findUserByUserIdentifier(String nickname);

    User createUser(String userNickname, String userPassword, String userSocialType);
}
