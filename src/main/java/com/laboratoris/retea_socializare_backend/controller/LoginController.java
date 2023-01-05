package com.laboratoris.retea_socializare_backend.controller;

import com.laboratoris.retea_socializare_backend.dto.JwtResponse;
import com.laboratoris.retea_socializare_backend.dto.UserLoginRequest;
import com.laboratoris.retea_socializare_backend.dto.UserRegisterRequest;
import com.laboratoris.retea_socializare_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody UserLoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest) {
        return authService.create(userRegisterRequest);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<JwtResponse> refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
