package com.projects.refresh_token.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private String expiresAt;
}
