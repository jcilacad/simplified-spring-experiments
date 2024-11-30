package com.projects.text_image_stability_ai.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.*;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Base64;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StabilityAiController {

    private final StabilityAiImageModel stabilityaiImageModel;

    @GetMapping("/image-gen")
    public ResponseEntity<String> imageGen(@RequestParam String message) {
        log.debug("imageGen({})", message);
        ImageResponse response = stabilityaiImageModel.call(new ImagePrompt(message,
                StabilityAiImageOptions.builder()
                        .withStylePreset("cinematic")
                        .withHeight(1024)
                        .withWidth(1024)
                        .build()));

        String b64Json = response.getResult().getOutput().getB64Json();
        log.info("Base64 JSON String: {}", b64Json);

        // Decode base64 and save it as an image file in the root directory
        try {
            byte[] imageBytes = Base64.getDecoder().decode(b64Json);
            String rootPath = Paths.get("").toAbsolutePath().toString();
            String fileName = rootPath + File.separator + "image.jpg"; // or "image.png" for PNG format
            try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
                fos.write(imageBytes);
            }
            log.info("Image saved as: {}", fileName);
        } catch (Exception e) {
            log.error("Error converting base64 to image: ", e);
            return ResponseEntity.status(500).body("Error converting base64 to image.");
        }

        return ResponseEntity.ok("Image successfully generated and saved.");
    }
}
