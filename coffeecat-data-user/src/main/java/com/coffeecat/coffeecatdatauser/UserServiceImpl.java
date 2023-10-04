package com.coffeecat.coffeecatdatauser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User findUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(
                UserException.UserNotFoundException::new
        );
    }
}
