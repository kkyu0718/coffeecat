package com.coffeecat.coffeecatbootgateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PostLoginGatewayFilterFactory extends AbstractGatewayFilterFactory<PostLoginGatewayFilterFactory.Config> {

    public PostLoginGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                String userId = response.getHeaders().getFirst("token");

                //TODO : chainging 으로 구현 가능할지 확인 필요
                // save redis and pub cookie
                exchange.getSession().mapNotNull(m -> m.getAttributes().put("userId", userId)).subscribe();
            }));
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }

}
