package com.projects.refresh_token.service.impl;

import com.projects.refresh_token.dto.request.RefreshTokenRequest;
import com.projects.refresh_token.dto.response.LoginResponse;
import com.projects.refresh_token.entity.RefreshToken;
import com.projects.refresh_token.entity.User;
import com.projects.refresh_token.repository.RefreshTokenRepository;
import com.projects.refresh_token.repository.UserRepository;
import com.projects.refresh_token.service.JwtService;
import com.projects.refresh_token.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;

    @Override
    public RefreshToken createRefreshToken(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(String.format("User not found with username: %s", username)));

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusMillis(900000)); // 15 Minutes
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public LoginResponse createAccessTokenByRefreshToken(RefreshTokenRequest refreshTokenRequest) {
        String token = refreshTokenRequest.getToken();
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException(String.format("Refresh token not found with token: %s", token)));

        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RuntimeException("Refresh token has expired.");
        }

        User user = refreshToken.getUser();
        String accessToken = jwtService.generateToken(user.getUsername());
        return LoginResponse.builder()
                .userId(user.getUserId().toString())
                .accessToken(accessToken)
                .refreshToken(token)
                .expiresAt(jwtService.extractExpiration(accessToken).toString())
                .build();
    }
}
