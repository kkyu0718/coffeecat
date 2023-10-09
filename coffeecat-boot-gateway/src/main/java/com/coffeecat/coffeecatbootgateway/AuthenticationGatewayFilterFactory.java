package com.coffeecat.coffeecatbootgateway;

import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {
    private final TokenAuthenticationProvider provider;

    public AuthenticationGatewayFilterFactory(TokenAuthenticationProvider provider) {
        super(Config.class);
        this.provider = provider;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String cookie = request.getCookies().getFirst("SESSION").getValue();
            String userId = null;

            if (provider.validate(cookie)) {
                userId = provider.authenticate(cookie);
            }

            Assert.notNull(userId);
            ServerHttpRequest.Builder builder = request.mutate().header("userId", userId);

            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
