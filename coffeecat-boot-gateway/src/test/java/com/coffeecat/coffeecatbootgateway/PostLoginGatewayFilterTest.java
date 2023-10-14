package com.coffeecat.coffeecatbootgateway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostLoginGatewayFilterTest extends BaseWebClientTests {
    AuthMockServer authMockServer = new AuthMockServer();
    ApiMockServer apiMockServer = new ApiMockServer();

    private final int authServerPort = 8081;
    private final int apiServerPort = 8083;

    private final AuthenticationGatewayFilterFactory factory = new AuthenticationGatewayFilterFactory();

    private ResponseCookie cookie;
    @BeforeAll
    void beforeAll() {
        authMockServer.startServer(authServerPort);
        apiMockServer.startServer(apiServerPort);

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

        System.out.println("Cookie = " + cookie.getValue());
    }

    @Test
    void sessionId와_cookie의_값은_같다() {



        //then
        //redis에 저장되어 있는 session 값과 발급된 cookie의 값이 같다.
//        webSessionManager.getSession()

        MockServerHttpRequest request = MockServerHttpRequest.get("http://localhost:8080/brand")
                .cookie(new HttpCookie("SESSION", cookie.getValue())).build();
        MockServerWebExchange exchange = MockServerWebExchange.from(request);
        GatewayFilterChain filterChain = mock(GatewayFilterChain.class);
        ArgumentCaptor<ServerWebExchange> captor = ArgumentCaptor.forClass(ServerWebExchange.class);
        when(filterChain.filter(captor.capture())).thenReturn(Mono.empty());

        GatewayFilter authFilter = factory.apply(new AuthenticationGatewayFilterFactory.Config());

        authFilter.filter(exchange, filterChain).block();

        Mono<WebSession> session = exchange.getSession();
        System.out.println("session = " + session.block().getId());
//        ServerHttpRequest exchangeRequest = exchange.getRequest();
//        System.out.println("exchangeRequest header = " + exchangeRequest.getHeaders());
//        System.out.println("exchangeRequest cookie = " + exchangeRequest.getCookies());

//        Assertions.assertEquals(1, exchangeRequest.getHeaders().getFirst("userId"));
    }
}
