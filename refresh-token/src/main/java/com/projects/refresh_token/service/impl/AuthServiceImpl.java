package com.projects.refresh_token.service.impl;

import com.projects.refresh_token.dto.request.LoginRequest;
import com.projects.refresh_token.dto.response.LoginResponse;
import com.projects.refresh_token.entity.RefreshToken;
import com.projects.refresh_token.service.AuthService;
import com.projects.refresh_token.service.JwtService;
import com.projects.refresh_token.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            RefreshToken refreshToken =  refreshTokenService.createRefreshToken(loginRequest.getUsername());
            String accessToken = jwtService.generateToken(loginRequest.getUsername());
            String expiresAt = jwtService.extractExpiration(accessToken).toString();
            String userId = jwtService.extractUserId(accessToken);

            return LoginResponse.builder()
                    .userId(userId)
                    .accessToken(accessToken)
                    .refreshToken(refreshToken.getToken())
                    .expiresAt(expiresAt)
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
