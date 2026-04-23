# API Contracts: Foundation Setup

## Overview
During the foundation phase, we establish the basic structure for API contracts that will be implemented in later phases. No external APIs are consumed in Phase 1, but we define the structure for future REST API development.

## REST API Structure (Future Implementation)
The Shortflix backend will expose RESTful APIs following standard conventions:

### Base URL Structure
```
/api/v1/{resource}
```

### Standard Response Format
```json
{
  "success": true,
  "data": {/* resource data */},
  "timestamp": "ISO 8601 timestamp",
  "message": "Optional message"
}
```

### Error Response Format
```json
{
  "success": false,
  "error": {
    "code": "ERROR_CODE",
    "message": "Human readable error message",
    "details": {/* optional validation errors */}
  },
  "timestamp": "ISO 8601 timestamp"
}
```

### HTTP Status Codes
- 200 OK: Successful GET, PUT, PATCH
- 201 Created: Successful POST
- 204 No Content: Successful DELETE
- 400 Bad Request: Validation errors, malformed requests
- 401 Unauthorized: Missing or invalid authentication
- 403 Forbidden: Authenticated but insufficient permissions
- 404 Not Found: Resource not found
- 409 Conflict: Resource conflict (e.g., duplicate email)
- 422 Unprocessable Entity: Semantic errors
- 500 Internal Server Error: Unexpected server errors
- 503 Service Unavailable: Temporary server issues

## API Endpoints by Phase

### Phase 2: Authentication
- POST `/api/v1/auth/register` - User registration
- POST `/api/v1/auth/login` - User login
- POST `/api/v1/auth/logout` - User logout
- POST `/api/v1/auth/refresh` - Token refresh

### Phase 3: Content Management (Admin)
- GET `/api/v1/admin/movies` - List movies (paginated)
- POST `/api/v1/admin/movies` - Create movie
- GET `/api/v1/admin/movies/{id}` - Get movie by ID
- PUT `/api/v1/admin/movies/{id}` - Update movie
- DELETE `/api/v1/admin/movies/{id}` - Delete movie
- GET `/api/v1/admin/categories` - List categories
- POST `/api/v1/admin/categories` - Create category

### Phase 4: Video Storage and Streaming
- GET `/api/v1/videos/{id}/stream` - Stream video content
- POST `/api/v1/videos/upload` - Upload video (admin only)
- GET `/api/v1/videos/{id}` - Get video metadata

### Phase 5: Public Content Access
- GET `/api/v1/movies` - List movies (public, paginated)
- GET `/api/v1/movies/{id}` - Get movie by ID (public)
- GET `/api/v1/movies/category/{categoryId}` - Filter by category
- GET `/api/v1/movies/search?q={query}` - Search movies

### Phase 6: Watch History
- POST `/api/v1/watch-history` - Record movie view
- GET `/api/v1/watch-history/user/{userId}` - Get user's watch history
- GET `/api/v1/watch-history/movie/{movieId}` - Get movie's view statistics

## Request/Response Patterns

### Pagination Response
```json
{
  "success": true,
  "data": {
    "content": [{/* array of items */}],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 20,
      "sort": [{"field": "title", "direction": "ASC"}]
    },
    "totalElements": 150,
    "totalPages": 8,
    "last": false,
    "first": true,
    "numberOfElements": 20
  },
  "timestamp": "2026-04-23T10:30:00Z",
  "message": "Movies retrieved successfully"
}
```

### Validation Error Response
```json
{
  "success": false,
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Input validation failed",
    "details": {
      "fieldErrors": [
        {
          "field": "email",
          "message": "Email must be valid format",
          "rejectedValue": "invalid-email"
        },
        {
          "field": "password",
          "message": "Password must be at least 8 characters",
          "rejectedValue": "123"
        }
      ]
    }
  },
  "timestamp": "2026-04-23T10:30:00Z"
}
```

## Security Considerations
All endpoints (except public ones) will require:
- Valid JWT token in Authorization header: `Bearer <token>`
- Role-based access control (ADMIN vs USER)
- Input validation and sanitization
- Protection against common vulnerabilities (SQL injection, XSS, CSRF)

## Versioning Strategy
- URI versioning: `/api/v1/...`
- Backward compatibility maintained within major versions
- Deprecation notices provided 6 months in advance of breaking changes
- Version documented in API documentation and client SDKs
