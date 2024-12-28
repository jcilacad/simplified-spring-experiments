package com.projects.spring_observability.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/observability")
    public String showMetrics() {
        return "Show Metrics";
    }
}
