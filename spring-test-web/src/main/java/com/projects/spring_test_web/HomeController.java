package com.projects.spring_test_web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String helloWorld() {
        return "Hello World";
    }
}
