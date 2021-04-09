package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.api.response.AuthResponse;
import main.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Обрабатывает все запросы /api/auth/*
 **/
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    @Autowired
    private AuthServiceImpl authService;

    @GetMapping(value = "/check")
    private ResponseEntity<AuthResponse> getCheck() {
        log.info("IN getCheck");
//        return ResponseEntity.ok("{\"result\": false}");
        return new ResponseEntity<>(authService.getCheck(), HttpStatus.OK);
    }
}
