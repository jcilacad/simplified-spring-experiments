package com.projects.refresh_token.controller;

import com.projects.refresh_token.dto.request.LoginRequest;
import com.projects.refresh_token.dto.request.RefreshTokenRequest;
import com.projects.refresh_token.dto.response.LoginResponse;
import com.projects.refresh_token.service.AuthService;
import com.projects.refresh_token.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(refreshTokenService.createAccessTokenByRefreshToken(refreshTokenRequest));
    }
}
