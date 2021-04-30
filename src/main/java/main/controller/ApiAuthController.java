package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.api.request.LoginRequest;
import main.api.response.LoginResponse;
import main.service.interfaces.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Обрабатывает все запросы /api/auth/*
 **/
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final SecurityService securityService;

    @Autowired
    public ApiAuthController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping(value = "/check")
    public ResponseEntity<LoginResponse> getCheck(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(new LoginResponse());
        } else {
            return ResponseEntity.ok(securityService.getLoginResponse(principal.getName()));
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> getLogin(
            @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(securityService.getLogin(loginRequest));
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<LoginResponse> getLogout(HttpServletRequest request,
                                                   HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return ResponseEntity.ok(new LoginResponse(true, null));
    }
}
