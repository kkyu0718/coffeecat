package com.coffeecat.coffeecatbootgateway;

import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PostLoginGatewayFilterFactory extends AbstractGatewayFilterFactory<PostLoginGatewayFilterFactory.Config> {
    private final TokenAuthenticationProvider provider;

    public PostLoginGatewayFilterFactory(TokenAuthenticationProvider provider) {
        super(Config.class);
        this.provider = provider;
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                String userId = response.getHeaders().getFirst("token");

                Assert.notNull(userId);

                log.info("[LoginGatewayFilter] userId {}", userId);

                String token = provider.createToken(userId);
                log.info("[LoginGatewayFilter] publish token {}", token);

                response.addCookie(ResponseCookie.from("SESSION", token)
                        .httpOnly(true)
                        .path("/")
                        .maxAge(1000)
                        .build());

                //TODO : chainging 으로 구현 가능할지 확인 필요
                // save in redis
                exchange.getSession().mapNotNull(m -> m.getAttributes().put(userId, token)).subscribe();
            }));
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }

}
