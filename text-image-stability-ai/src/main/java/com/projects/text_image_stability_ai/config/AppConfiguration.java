package com.projects.text_image_stability_ai.config;

import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    StabilityAiImageModel imageModel(@Value("${spring.ai.stabilityai.api-key}") String apiKey) {
        return new StabilityAiImageModel(new StabilityAiApi(apiKey));
    }
}
