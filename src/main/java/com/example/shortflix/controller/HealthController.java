package com.example.shortflix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    private final DataSource dataSource;

    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        logger.debug("Health check endpoint called");

        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");

        try (Connection connection = dataSource.getConnection()) {
            boolean dbHealthy = connection.isValid(2);
            health.put("database", dbHealthy ? "UP" : "DOWN");
            logger.debug("Database health: {}", dbHealthy ? "UP" : "DOWN");
        } catch (Exception e) {
            logger.warn("Database health check failed: {}", e.getMessage());
            health.put("database", "DOWN");
        }

        return ResponseEntity.ok(health);
    }
}