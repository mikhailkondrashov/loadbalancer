package com.example.demo.service.impl;

import com.example.demo.service.ComputeCommunicationService;
import com.example.demo.utils.HttpRequestMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

@Service
public class ComputeCommunicationServiceImpl implements ComputeCommunicationService {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public HttpResponse<String> send(Object request) throws IOException, InterruptedException {
        return httpClient.send(HttpRequestMapper.map(request), HttpResponse.BodyHandlers.ofString());
    }
}
