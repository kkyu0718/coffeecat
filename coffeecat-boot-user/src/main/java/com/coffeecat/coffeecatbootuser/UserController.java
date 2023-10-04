package com.coffeecat.coffeecatbootuser;

import com.coffeecat.coffeecatdatauser.User;
import com.coffeecat.coffeecatdatauser.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
