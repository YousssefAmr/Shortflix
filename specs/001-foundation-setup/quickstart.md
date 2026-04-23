# Quick Start Guide: Foundation Setup

## Overview
This guide provides instructions for building, running, and testing the Shortflix foundation setup. It validates that the Spring Boot application initializes correctly with proper project structure and database connectivity.

## Prerequisites
- JDK 17 or higher
- Maven 3.8+
- MySQL server running on localhost:3306
- Database named 'shortflix' created
- MySQL user 'shortflix_user' with password 'shortflix_pass' (or adjust in application.properties)

## Building the Application

```bash
# Navigate to project root
cd C:\Users\Youssef\IdeaProjects\Shortflix

# Clean and build the project
mvn clean install
```

Expected output: BUILD SUCCESS

## Running the Application

```bash
# Run the Spring Boot application
mvn spring-boot:run
```

The application should start successfully and display output similar to:
```
2026-04-23 11:30:00.000  INFO 12345 --- [           main] c.y.s.ShortflixApplication        : Starting ShortflixApplication v1.0.0 using Java 17.0.0 on DESKTOP-ABC123 with PID 12345
2026-04-23 11:30:00.001  INFO 12345 --- [           main] c.y.s.ShortflixApplication        : No active profile set, falling back to 1 default profile: "default"
2026-04-23 11:30:00.500  INFO 12345 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServlet : Tomcat initialized with port(s): 8080 (http)
2026-04-23 11:30:00.510  INFO 12345 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-04-23 11:30:00.510  INFO 12345 --- [           main] o.apache.catalina.core.StandardEngine   : Starting Servlet engine: [Apache Tomcat/10.1.15]
2026-04-23 11:30:00.600  INFO 12345 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-04-23 11:30:00.600  INFO 12345 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 500 ms
2026-04-23 11:30:00.800  INFO 12345 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2026-04-23 11:30:00.801  INFO 12345 --- [           main] c.y.s.ShortflixApplication        : Started ShortflixApplication in 1.2 seconds (JVM running for 1.5)
```

## Testing the Application

### Health Check Endpoint
Once the application is running, test the health endpoint:

```bash
# Using curl
curl -i http://localhost:8080/actuator/health

# Expected response:
# HTTP/1.1 200 OK
# Content-Type: application/vnd.spring-boot.actuator.v3+json
# Content-Length: 15
#
# {"status":"UP"}
```

### Alternative: Using HTTPie
```bash
http :8080/actuator/health
```

### Verify Application Information
```bash
curl -i http://localhost:8080/actuator/info
```

### Database Connection Test
Check that the application connects to MySQL without errors by reviewing the startup logs for lines like:
```
2026-04-23 11:30:01.000  INFO 12345 --- [           main] com.zaxxer.hikari.HikariDataSource   : HikariPool-1 - Starting...
2026-04-23 11:30:01.200  INFO 12345 --- [           main] com.zaxxer.hikari.HikariDataSource   : HikariPool-1 - Start completed.
```

## Stopping the Application
To stop the running application, press `Ctrl+C` in the terminal where it's running.

## Project Structure Verification
Verify the expected package structure exists:

```bash
# List Java source directories
find src/main/java -type d

# Expected output:
# src/main/java
# src/main/java/com
# src/main/java/com/youssef
# src/main/java/com/youssef/shortflix
# src/main/java/com/youssef/shortflix/config
# src/main/java/com/youssef/shortflix/controller
# src/main/java/com/youssef/shortflix/repository
# src/main/java/com/youssef/shortflix/service
# src/main/java/com/youssef/shortflix/model
```

## Troubleshooting

### Port Already in Use
If you see an error like `Port 8080 is already in use`, either:
1. Stop the existing process using port 8080
2. Change the port in `src/main/resources/application.properties`:
   ```
   server.port=8081
   ```

### Database Connection Errors
If you see database connection errors:
1. Verify MySQL is running: `systemctl status mysql` (Linux) or check MySQL service (Windows/macOS)
2. Verify database credentials in `src/main/resources/application.properties`
3. Ensure the 'shortflix' database exists: `CREATE DATABASE shortflix;`
4. Ensure the user has proper permissions: `GRANT ALL PRIVILEGES ON shortflix.* TO 'shortflix_user'@'localhost';`

### Build Failures
If Maven build fails:
1. Verify JDK 17 is installed: `java -version`
2. Verify Maven is installed: `mvn -v`
3. Check internet connectivity for dependency downloads
4. Try `mvn clean install -U` to force update of dependencies

## Validation Checklist
After completing these steps, verify:
- [ ] Application starts without errors
- [ ] Application responds to health check endpoint
- [ ] Startup logs show successful database connection
- [ ] Project structure follows package-by-layer approach
- [ ] No exceptions related to missing dependencies or configuration
- [ ] Application can be stopped and restarted cleanly

## Next Steps
Once the foundation is working correctly, proceed to implement:
1. User entity and authentication system (Phase 2)
2. Movie and category entities with admin APIs (Phase 3)
3. Video storage and streaming capabilities (Phase 4)