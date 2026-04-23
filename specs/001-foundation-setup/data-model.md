# Data Model: Foundation Setup

## Overview
The foundation phase focuses on infrastructure setup rather than business entities. However, we establish the basic structure for future entity development.

## Package Structure
```
com/youssef/shortflix/
├── config/         # Configuration classes
├── controller/     # REST controllers (handles HTTP requests)
├── service/        # Business logic layer
├── repository/     # Data access layer (JPA repositories)
└── model/          # JPA entities (to be developed in later phases)
```

## Future Entities (Placeholder Structure)
Although no entities are implemented in Phase 1, we establish the pattern for future development:

### User Entity (Phase 2)
```java
package com.youssef.shortflix.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private LocalDate birthDate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    // Getters and setters
}
```

### Movie Entity (Phase 3)
```java
package com.youssef.shortflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    private Integer duration; // in minutes
    
    @Column(nullable = false)
    private String videoUrl;
    
    private String thumbnailUrl;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    // Getters and setters
}
```

### Category Entity (Phase 3)
```java
package com.youssef.shortflix.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy = "category")
    private Set<Movie> movies;
    
    // Getters and setters
}
```

### WatchHistory Entity (Phase 6)
```java
package com.youssef.shortflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "watch_history")
public class WatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(nullable = false)
    private LocalDateTime watchedAt;
    
    // Getters and setters
}
```

## Repository Interfaces (Phase 3+)
```java
package com.youssef.shortflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youssef.shortflix.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
```

## Configuration Classes (Phase 1)
```java
package com.youssef.shortflix.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // Application-wide configuration beans
}
```

## Relationships
- User 1:N WatchHistory (one user can have many watch history records)
- Movie N:1 Category (many movies belong to one category)
- Category 1:N Movie (one category can have many movies)
- Movie N:1 WatchHistory (many watch history records for one movie)

## Validation Rules (Future)
- User.email: must be valid email format, unique
- User.password: minimum 8 characters
- Movie.title: required, minimum 2 characters
- Movie.duration: positive integer between 10 and 20 (per PLAN.md)
- Category.name: required, unique
