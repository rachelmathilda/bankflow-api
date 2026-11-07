package com.bankflow.bankflow_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankflow.bankflow_api.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping()
    public String login(String username, String password) {
        return authService.login(username, password);
    }

    @PostMapping()
    public String register(String username, String password) {
        return authService.register(username, password);
    }

    @GetMapping 
    public Boolean logout(String token){
        return authService.logout(token);
    }
}
