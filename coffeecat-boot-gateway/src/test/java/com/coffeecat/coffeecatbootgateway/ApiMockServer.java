package com.coffeecat.coffeecatbootgateway;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;

import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ApiMockServer {
    private ClientAndServer mockServer;

    public void startServer(int port) {
        mockServer = ClientAndServer.startClientAndServer(port);
    }

    public void stopServer() {
        mockServer.stop();
    }

    public void createExpectationForApi() {
        new MockServerClient("localhost", 8083).when(
                        request()
                                .withMethod("GET")
                                .withPath("/brand"),
                        Times.exactly(1))
                .respond(
                        response()
                                .withHeader("userId", request().getFirstHeader("userId"))
                                .withStatusCode(200)
                                .withDelay(TimeUnit.SECONDS, 1)
                );
    }
}
