package com.coffeecat.coffeecatbootgateway;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMap(Map response, String key) {
        assertThat(response).containsKey(key).isInstanceOf(Map.class);
        return (Map<String, Object>) response.get(key);
    }

    public static void assertStatus(ClientResponse response, HttpStatusCode status) {
        HttpStatusCode statusCode = response.statusCode();
        assertThat(statusCode).isEqualTo(status);
    }

}