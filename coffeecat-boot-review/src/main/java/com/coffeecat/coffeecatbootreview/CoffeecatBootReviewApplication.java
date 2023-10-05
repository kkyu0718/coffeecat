package com.coffeecat.coffeecatbootreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeecatBootReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootReviewApplication.class, args);
    }

}
