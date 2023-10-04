package com.coffeecat.coffeecatbootuser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacadeService userFacadeService;

    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@PathVariable int userId) {
        return UserResponseDto.fromEntity(userFacadeService.getUserById(userId));
    }

}
