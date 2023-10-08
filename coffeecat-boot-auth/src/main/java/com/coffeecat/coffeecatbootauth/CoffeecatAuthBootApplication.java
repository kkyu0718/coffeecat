package com.coffeecat.coffeecatbootauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.coffeecat.coffeecatdatauser")
@EnableJpaRepositories("com.coffeecat.coffeecatdatauser")
@SpringBootApplication(scanBasePackages = "com.coffeecat", exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing
public class CoffeecatAuthBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatAuthBootApplication.class, args);
    }

}
