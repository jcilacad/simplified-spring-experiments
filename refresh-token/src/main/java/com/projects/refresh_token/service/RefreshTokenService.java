package com.projects.refresh_token.service;

import com.projects.refresh_token.dto.request.RefreshTokenRequest;
import com.projects.refresh_token.dto.response.LoginResponse;
import com.projects.refresh_token.entity.RefreshToken;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(String username);

    LoginResponse createAccessTokenByRefreshToken(RefreshTokenRequest refreshTokenRequest);
}
