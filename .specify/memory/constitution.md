<!-- Sync Impact Report:
- Version change: (initial) → 1.0.0
- Modified principles: 
  * [PRINCIPLE_1_NAME] → I. Layered Architecture with Separation of Concerns
  * [PRINCIPLE_2_NAME] → II. Test-Driven Development (NON-NEGOTIABLE)
  * [PRINCIPLE_3_NAME] → III. Security-First Approach
  * [PRINCIPLE_4_NAME] → IV. Observability and Monitoring
  * [PRINCIPLE_5_NAME] → V. Performance Consciousness
- Added sections: Technology Stack and Constraints, Development Workflow and Quality Gates, Governance
- Removed sections: None (all template sections replaced with content)
- Templates requiring updates:
  * .specify/templates/plan-template.md: ✅ updated (Constitution Check section)
  * .specify/templates/spec-template.md: ⚠ pending (references to [PRINCIPLE_X_NAME] and [SECTION_X_NAME] placeholders)
  * .specify/templates/tasks-template.md: ⚠ pending (references to constitution principles)
  * .specify/templates/commands/*.md: ⚠ pending (no command templates found)
- Follow-up TODOs: Update template files to reflect new constitution principles
-->
# Shortflix Constitution
<!-- Constitution for Shortflix Spring Boot Backend -->

## Core Principles

### I. Layered Architecture with Separation of Concerns
Follow clean layered architecture: Controller → Service → Repository. Each layer has distinct responsibilities: Controllers handle HTTP requests/responses, Services contain business logic, Repositories manage data persistence. No layer should skip another or contain concerns from other layers.

### II. Test-Driven Development (NON-NEGOTIABLE)
All development follows TDD: Write failing tests first, then implement minimal code to pass, then refactor. Tests must cover unit, integration, and API levels. No feature is complete without comprehensive tests that are reviewed and approved.

### III. Security-First Approach
Implement security at every level: Use JWT for authentication, BCrypt for password hashing, validate all inputs, protect endpoints appropriately, and never expose internal errors or stack traces to clients. Security considerations must be addressed in every phase.

### IV. Observability and Monitoring
Build in observability from the start: Structured logging, meaningful metrics, health check endpoints, and proper error handling. Systems must be debuggable in production without requiring redeployment or excessive debugging sessions.

### V. Performance Consciousness
Consider performance implications in design: Use appropriate caching strategies, database indexing, connection pooling, and efficient queries. Premature optimization is avoided, but performance requirements are considered during architecture and implementation.

## Technology Stack and Constraints
Use Spring Boot 3.x with Java 17+, MySQL for persistence, and JWT for authentication. Follow RESTful API design principles with proper HTTP status codes. All dependencies must be managed through Maven. Local file storage is acceptable for MVP with path to cloud storage migration.

## Development Workflow and Quality Gates
Follow the 10-phase implementation plan strictly. Each phase must have corresponding specs written before implementation. Code reviews require approval from at least one other developer. All changes must be accompanied by updated tests. CI/CD pipeline must pass before merging to main branch.

## Governance
This constitution supersedes all other practices and guidelines within the project. Amendments require proper documentation, review approval, and a migration plan if breaking changes are introduced. All PRs and reviews must verify compliance with these principles. Complexity in implementation must be justified and reviewed.

**Version**: 1.0.0 | **Ratified**: 2026-04-23 | **Last Amended**: 2026-04-23
<!-- Initial constitution setup for Shortflix Spring Boot Backend -->