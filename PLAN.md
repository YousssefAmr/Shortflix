# Shortflix - PLAN

## Summary
Build a backend for a short movie streaming platform

Target duration per video  
10 to 20 minutes

Core goal  
Stable MVP that supports upload, browsing, and streaming

Tech stack  
Spring Boot  
MySQL  
JWT authentication

Scope  
Backend only

---

## Phase 1: Foundation

### Goal
Create a solid base for development

### Deliverables
- Running Spring Boot app
- Clean project structure
- Database connection

### Tasks
- Initialize project
- Setup layers
    - controller
    - service
    - repository
    - config
- Configure MySQL
- Setup JPA and migrations
- Add global exception handler
- Add base logging

### Specs to write
- project-structure.spec
- database-config.spec
- global-exception.spec

---

## Phase 2: Authentication

### Goal
Secure access

### Deliverables
- Register and login APIs
- JWT authentication

### Tasks
- Create User entity
    - id
    - name
    - email
    - password
    - birthDate
    - gender
    - role
- Implement register API
- Implement login API
- Hash passwords using BCrypt
- Generate JWT token
- Add authentication filter
- Protect endpoints

### Specs to write
- user-entity.spec
- auth-api.spec
- jwt-security.spec

---

## Phase 3: Content Management

### Goal
Allow admin to manage movies

### Deliverables
- Admin APIs to manage content

### Tasks
- Create Movie entity
    - id
    - title
    - description
    - duration
    - videoUrl
    - thumbnailUrl
    - categoryId
- Create Category entity
    - id
    - name
- Admin APIs
    - create movie
    - update movie
    - delete movie
    - list movies
- Validate input data

### Specs to write
- movie-entity.spec
- category-entity.spec
- admin-content-api.spec

---

## Phase 4: Video Storage and Streaming

### Goal
Serve video content

### Deliverables
- Streaming endpoint

### Tasks
- Store video files
    - local storage for MVP
- Build streaming endpoint
- Return video via HTTP
- Support partial content requests

### Specs to write
- file-storage.spec
- streaming-api.spec

---

## Phase 5: Public Content Access

### Goal
Allow users to browse and watch

### Deliverables
- Public APIs for movies

### Tasks
- Get all movies
- Get movie by id
- Filter by category
- Add pagination
- Optimize queries

### Specs to write
- public-movie-api.spec
- pagination.spec

---

## Phase 6: Watch History

### Goal
Track user activity

### Deliverables
- Save watched movies

### Tasks
- Create WatchHistory entity
    - id
    - userId
    - movieId
    - watchedAt
- Save record on play

### Specs to write
- watch-history.spec

---

## Phase 7: Performance

### Goal
Improve response time

### Deliverables
- Faster APIs under normal load

### Tasks
- Add caching for movie list
- Add database indexes
- Tune connection pool
- Reduce unnecessary queries

### Specs to write
- caching.spec
- database-indexing.spec

---

## Phase 8: Security

### Goal
Protect system

### Deliverables
- Safe API usage

### Tasks
- Validate all inputs
- Restrict admin endpoints
- Hide internal errors
- Add basic rate limiting on auth

### Specs to write
- validation.spec
- security-rules.spec

---

## Phase 9: Testing

### Goal
Ensure correctness

### Deliverables
- Tested core features

### Tasks
- Unit tests for services
- Integration tests for APIs
- Test authentication flow

### Specs to write
- testing.spec

---

## Phase 10: Deployment

### Goal
Make system ready to run

### Deliverables
- Deployable backend

### Tasks
- Dockerize application
- Add environment configs
- Add health check endpoint
- Prepare production config

### Specs to write
- docker.spec
- deployment.spec

---

## MVP Checklist

- User can register and login
- Admin can upload movies
- Movies stored and accessible
- Users can browse movies
- Users can stream videos
- Watch history saved
- APIs respond reliably

---

## Excluded from MVP

- Recommendation system
- Comments or ratings
- Payments
- Advanced analytics
- Video encoding pipeline

---

## Execution Order

1. Phase 1
2. Phase 2
3. Phase 3
4. Phase 4
5. Phase 5
6. Phase 6
7. Phase 7
8. Phase 8
9. Phase 9
10. Phase 10  