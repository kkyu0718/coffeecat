package com.coffeecat.coffeecatbootbrand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/brand")
public class BrandController {
    @GetMapping("/hello")
    public String hello(@RequestHeader("userId") int userId) {
        log.info("capsule controller userId {}", userId);
        return "hello";
    }
}
