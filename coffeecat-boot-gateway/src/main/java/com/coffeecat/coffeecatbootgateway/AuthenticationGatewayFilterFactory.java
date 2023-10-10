package com.coffeecat.coffeecatbootgateway;

import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

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
            final ServerHttpRequest request = exchange.getRequest();

//            String userId = exchange.getSession()
//                    .mapNotNull(m -> m.getAttributes().get("userId"))
//                    .map(m -> (String) m)
//                    .blockOptional()
//                    .orElseThrow(() -> new RuntimeException("no userId in session - need login"));
//            ServerHttpRequest.Builder builder = request.mutate().header("userId", "temp");
//
//            return chain.filter(exchange.mutate().request(builder.build()).build());
            return exchange.getSession()
                    .mapNotNull(m -> (String) m.getAttributes().get("userId"))
                    .map(m -> request.mutate().header("userId", m))
                    .map(m -> exchange.mutate().request(m.build()))
                    .flatMap(m -> chain.filter(m.build()))
                    .doOnError(m -> new RuntimeException("no userId in session - need login")); //TODO 에러 처리 필
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
