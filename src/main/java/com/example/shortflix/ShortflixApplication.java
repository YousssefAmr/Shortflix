package com.example.shortflix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShortflixApplication {

    private static final Logger logger = LoggerFactory.getLogger(ShortflixApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Shortflix application...");
        SpringApplication.run(ShortflixApplication.class, args);
        logger.info("Shortflix application started successfully");
    }

}
