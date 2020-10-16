package bcp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController
{
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/hello")
    public String welcomeMessage() {
        double value = Math.random();
        logger.info("My log message {}", value);
        return "Value: " + value;
    }
}