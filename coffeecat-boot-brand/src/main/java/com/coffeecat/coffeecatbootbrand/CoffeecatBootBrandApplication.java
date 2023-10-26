package com.coffeecat.coffeecatbootbrand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.coffeecat.coffeecatdatabrand")
@SpringBootApplication(scanBasePackages = "com.coffeecat")
public class CoffeecatBootBrandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootBrandApplication.class, args);
    }

}
