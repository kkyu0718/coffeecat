package com.coffeecat.coffeecatbootuser;

import com.coffeecat.coffeecatdatauser.User;
import com.coffeecat.coffeecatdatauser.UserService;
import com.coffeecat.coffeecatdatauser.UserServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeService {
    private final UserService userService;

    public UserFacadeService(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    public User getUserById(int userId) {
        return userService.findUserById(userId);
    }
}
