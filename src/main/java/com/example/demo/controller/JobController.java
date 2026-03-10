package com.example.demo.controller;

import com.example.demo.service.ComputeCommunicationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
public class JobController {
    private final ComputeCommunicationService computeCommunicationService;

    @RequestMapping("/**")
    public ResponseEntity<?> dispatch(HttpServletRequest request) {
        Thread currentThread = Thread.currentThread();
        System.out.println("=== ИНФОРМАЦИЯ О ПОТОКЕ ===");
        System.out.println("Имя потока: " + currentThread.getName());
        System.out.println("ID потока: " + currentThread.threadId());
        System.out.println("Это виртуальный поток? " + currentThread.isVirtual());
        System.out.println("Группа потоков: " + currentThread.getThreadGroup());
        System.out.println("===========================");
        String path = request.getRequestURI();

        System.out.println(path);
        if (!path.equals("/test")) {
            try {
                HttpResponse<String> send = computeCommunicationService.send(path);
                return ResponseEntity.ok(send.statusCode());
            } catch (IOException | InterruptedException e) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok("ok");
    }
}
