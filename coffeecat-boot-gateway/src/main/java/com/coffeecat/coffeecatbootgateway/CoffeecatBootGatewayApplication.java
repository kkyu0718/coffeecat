package com.coffeecat.coffeecatbootgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.SaveSessionGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoffeecatBootGatewayApplication {
    static final String host = "localhost";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder,
                                           PostLoginGatewayFilterFactory postLoginGatewayFilterFactory) {
        PostLoginGatewayFilterFactory.Config config = new PostLoginGatewayFilterFactory.Config();
        SaveSessionGatewayFilterFactory saveSessionGatewayFilterFactory = new SaveSessionGatewayFilterFactory();

        return builder.routes()
                .route("login-route", r -> r.path("/auth/login")
                        .filters(f -> f
                                .filter(saveSessionGatewayFilterFactory.apply(new Object()))
                                .filter(postLoginGatewayFilterFactory.apply(config)))
                        .uri("http://localhost:8081"))
                .route("auth-route", r -> r.path("/auth/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootGatewayApplication.class, args);
    }
}
