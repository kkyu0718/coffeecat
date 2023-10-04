package com.coffeecat.coffeecatdatauser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findUserByUserIdentifier(String userIdentifier) {
        return userRepository.findByUserIdentifier(userIdentifier);
    }

    @Override
    public User createUser(String userIdentifier, String encodedUserPassword, String userSocialType) {
        return userRepository.save(User.builder()
                        .userIdentifier(userIdentifier)
                        .userPassword(encodedUserPassword)
                        .userSocialType(User.SocialType.valueOf(userSocialType))
                .build());
    }


}
