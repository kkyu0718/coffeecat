package com.coffeecat.coffeecatdatareview;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories(basePackageClasses = ReviewRepository.class)
@EntityScan(basePackageClasses = Review.class)
public class JpaTestConfig {

}
