package com.example.demo.service;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface ComputeCommunicationService {
    HttpResponse<String> send(Object request) throws IOException, InterruptedException;
}
