package com.coffeecat.coffeecatbootuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.coffeecat.coffeecatdatauser")
@EnableJpaRepositories("com.coffeecat.coffeecatdatauser")
@SpringBootApplication(scanBasePackages = "com.coffeecat")
@EnableJpaAuditing
public class CoffeecatBootUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeecatBootUserApplication.class, args);
	}

}
