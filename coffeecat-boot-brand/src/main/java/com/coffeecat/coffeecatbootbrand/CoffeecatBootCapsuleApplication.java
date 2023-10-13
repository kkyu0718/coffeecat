package com.coffeecat.coffeecatbootbrand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeecatBootCapsuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootCapsuleApplication.class, args);
    }

}
