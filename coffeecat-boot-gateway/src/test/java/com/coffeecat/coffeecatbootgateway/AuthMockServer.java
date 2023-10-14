package com.coffeecat.coffeecatbootgateway;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.JsonBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;

public class AuthMockServer {
    private ClientAndServer mockServer;

    public void startServer(int port) {
        mockServer = ClientAndServer.startClientAndServer(port);
    }

    public void stopServer() {
        mockServer.stop();
    }

    public void createExpectationForLogin(String userIdentifier, String userPassword, String userSocialType) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userIdentifier", userIdentifier);
        requestBody.put("userPassword", userPassword);
        requestBody.put("userSocialType", userSocialType);

        new MockServerClient("127.0.0.1", 8081).when(
                request()
                        .withMethod("POST")
                        .withPath("/auth/login")
                        .withBody(JsonBody.json(requestBody)),
                Times.exactly(1))
                .respond(
                        response()
                                .withHeader("token", String.valueOf(1))
                                .withDelay(TimeUnit.SECONDS, 1)
                );
    }

    public void createExpectationForSignup(String userIdentifier, String userPassword, String userSocialType) {
        new MockServerClient("localhost", 8081).when(
                request()
                        .withMethod("POST")
                        .withPath("/auth/signup")
                        .withBody(exact(String.format("{userIdentifier:'%s' , " +
                                "userPasswore:'%s" +
                                "userSocialType: '%s'}", userIdentifier, userPassword, userSocialType))),
                Times.exactly(1))
                .respond(
                        response()
                                .withStatusCode(201)
                                .withDelay(TimeUnit.SECONDS, 1)
                );
    }
}
