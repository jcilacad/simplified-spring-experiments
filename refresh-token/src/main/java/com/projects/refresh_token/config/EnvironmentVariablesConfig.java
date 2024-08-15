package com.projects.refresh_token.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties
@RequiredArgsConstructor
public class EnvironmentVariablesConfig {

    private String jwtSecretKey;
}
