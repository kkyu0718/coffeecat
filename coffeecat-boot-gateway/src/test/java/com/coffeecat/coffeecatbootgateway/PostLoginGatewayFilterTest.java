package com.coffeecat.coffeecatbootgateway;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.test.annotation.DirtiesContext;
import redis.embedded.RedisServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostLoginGatewayFilterTest extends BaseWebClientTests {
    AuthMockServer authMockServer = new AuthMockServer();
    ApiMockServer apiMockServer = new ApiMockServer();
    Logger log;

    private final int authServerPort = 8081;
    private final int apiServerPort = 8083;
    private final int redisPort = 6380;

    private ResponseCookie cookie;
    private RedisServer redisServer;

    @BeforeAll
    void beforeAll() throws IOException {
        log = LoggerFactory.getLogger("PostLoginGatewayFilterTest.class");

        authMockServer.startServer(authServerPort);
        apiMockServer.startServer(apiServerPort);

        redisServer = RedisServer.builder()
                .setting("maxmemory 10M")
//                .setting("requirepass root123!")
                .port(redisPort)
                .build();
        try {
            redisServer.start();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @AfterAll
    void cleanup() {
        redisServer.stop();
    }

    @Test
    void sessionId와_cookie의_값은_같다() {
        //given
        String userIdentifier = "userIdentifier";
        String userPassword = "userPassword";
        String userSocialType = "USERPASSWORD";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userIdentifier", userIdentifier);
        requestBody.put("userPassword", userPassword);
        requestBody.put("userSocialType", userSocialType);

        authMockServer.createExpectationForLogin(userIdentifier, userPassword, userSocialType);
        apiMockServer.createExpectationForApi();

        //when
        //userId 1 인 session 이 생성된다.
        cookie = testClient.post()
                .uri("/auth/login")
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Object.class)
                .getResponseCookies().getFirst("SESSION");

        log.info("Cookie = {}", cookie.getValue());

        //then
        HttpHeaders requestHeaders = testClient.get()
                .uri("/brand")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Object.class)
                .getRequestHeaders();

        log.info("exchangeResponse {}", requestHeaders.entrySet());

        Assertions.assertEquals(1, requestHeaders.getFirst("userId"));
    }

}
