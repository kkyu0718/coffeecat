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
                                           PostLoginGatewayFilterFactory postLoginGatewayFilterFactory,
                                           AuthenticationGatewayFilterFactory authenticationGatewayFilterFactory) {
        PostLoginGatewayFilterFactory.Config postLoginGatewayFilterFactoryConfig = new PostLoginGatewayFilterFactory.Config();
        SaveSessionGatewayFilterFactory saveSessionGatewayFilterFactory = new SaveSessionGatewayFilterFactory();

        AuthenticationGatewayFilterFactory.Config authenticationGatewayFilterFactoryConfig = new AuthenticationGatewayFilterFactory.Config();
        return builder.routes()
                .route("login-route", r -> r.path("/auth/login")
                        .filters(f -> f
                                .filter(postLoginGatewayFilterFactory.apply(postLoginGatewayFilterFactoryConfig)))
                        .uri("http://localhost:8081"))
                .route("auth-route", r -> r.path("/auth/**")
                        .uri("http://localhost:8081")
                )
                .route("brand-route", r -> r.path("/brand/**")
                        .filters(f -> f.filter(authenticationGatewayFilterFactory.apply(authenticationGatewayFilterFactoryConfig)))
                        .uri("http://localhost:8083")
                )
                //TODO route eroor handle
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeecatBootGatewayApplication.class, args);
    }
}
