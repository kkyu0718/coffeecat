package com.coffeecat.coffeecatbootbrand;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
해당 config 가 CoffeecatBootBrandApplication main 에 있으면
webmvctest 에서 entitymanager 의존성을 요구하게 되기 때문에 따로 분리
*/
@Configuration
@EnableJpaRepositories("com.coffeecat.coffeecatdatabrand")
@EnableJpaAuditing
public class JpaConfiguration {
}
