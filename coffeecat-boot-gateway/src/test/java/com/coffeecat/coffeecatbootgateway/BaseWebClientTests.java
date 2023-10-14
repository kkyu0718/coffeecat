package com.coffeecat.coffeecatbootgateway;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

public class BaseWebClientTests {
    @LocalServerPort
    protected int port = 0;
    protected WebTestClient testClient;
    protected WebClient webClient;
    protected String baseUri;

    @BeforeEach
    public void setup() throws Exception {
        setup(new ReactorClientHttpConnector(), "http://localhost:" + port);
    }

    protected void setup(ClientHttpConnector httpConnector, String baseUri) {
        this.baseUri = baseUri;
        this.webClient = WebClient.builder()
                .clientConnector(httpConnector)
                .baseUrl(this.baseUri)
                .build();
        this.testClient = WebTestClient
                .bindToServer(httpConnector)
                .baseUrl(this.baseUri)
                .build();
    }

}
