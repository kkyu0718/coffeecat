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

    public AuthenticationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            final ServerHttpRequest request = exchange.getRequest();

            return exchange.getSession()
//                    .doOnEach(m -> System.out.println("WebSession = " + m.get().getId()))
                    .mapNotNull(m -> (String) m.getAttributes().get("userId"))
                    .map(m -> request.mutate().header("userId", m))
                    .map(m -> exchange.mutate().request(m.build()))
                    .flatMap(m -> chain.filter(m.build()));
            //TODO 500 internal error, 401 unauthorized error handle
//                    .onErrorMap(ex -> new BusinessException.NoSessionException());
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
