package com.projects.dynamic_logging.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home() {
        logger.trace("This is a TRACE level message for demo purpose");
        logger.debug("This is a DEBUG level message for demo purpose");
        logger.info("This is a INFO level message for demo purpose");
        logger.warn("This is a WARN level message for demo purpose");
        logger.error("This is a ERROR level message for demo purpose");
        return "Hello World";
    }
}
