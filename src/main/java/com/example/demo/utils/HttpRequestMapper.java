package com.example.demo.utils;

import lombok.experimental.UtilityClass;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

@UtilityClass
public class HttpRequestMapper {
    public HttpRequest map(Object request) {
        return HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/test"))
                .POST(HttpRequest.BodyPublishers.ofString(request.toString()))
                .timeout(Duration.ofMillis(2_000))
                .build();
    }
}
