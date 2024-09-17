package com.projects.optimizedasync.controller;

import com.projects.optimizedasync.serivce.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailService emailService;

    @GetMapping
    public String sendEmail() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        Thread.sleep(2000);
        emailService.sendEmail();
        long t2 = System.currentTimeMillis();
        return String.format("Registering user took (%s) ms", (t1-t2));
    }
}
