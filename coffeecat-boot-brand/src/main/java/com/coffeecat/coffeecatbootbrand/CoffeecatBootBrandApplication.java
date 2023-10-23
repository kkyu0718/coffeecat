package com.coffeecat.coffeecatbootbrand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.coffeecat.coffeecatdatabrand")
@EnableJpaRepositories("com.coffeecat.coffeecatdatabrand")
@SpringBootApplication(scanBasePackages = "com.coffeecat")
@EnableJpaAuditing
public class CoffeecatBootBrandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootBrandApplication.class, args);
    }

}
