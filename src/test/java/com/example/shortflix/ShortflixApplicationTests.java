package com.example.shortflix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShortflixApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
        assertNotNull(dataSource, "DataSource should be configured");
    }

    @Test
    void applicationStarts() {
        assertTrue(port > 0, "Application should have a valid port assigned");
    }

    @Test
    void databaseConnectionEstablished() {
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection, "Database connection should be established");
            assertFalse(connection.isClosed(), "Database connection should be open");
        } catch (Exception e) {
            fail("Database connection should be established: " + e.getMessage());
        }
    }
}
