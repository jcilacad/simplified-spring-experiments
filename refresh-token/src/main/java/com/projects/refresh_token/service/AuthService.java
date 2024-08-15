package com.projects.refresh_token.service;

import com.projects.refresh_token.dto.request.LoginRequest;
import com.projects.refresh_token.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
