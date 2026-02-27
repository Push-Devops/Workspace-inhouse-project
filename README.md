## Workspace-inhouse-project

This repository contains in‑house learning and practice projects, starting from simple building blocks and gradually moving toward more advanced, multi‑service architectures.

### Current project: `accounts` microservice

The first service in this repo is a **Spring Boot 4 (4.0.3)** based `accounts` microservice, built with **Java 25**:

- **Tech stack**
  - Spring Boot 4.0.3
  - Java 25
  - Spring Web MVC
  - Spring Data JPA
  - Spring Boot Actuator
  - H2 in‑memory database
  - Spring Validation
  - Lombok

- **Runtime configuration**
  - Server runs on **port 8080**.
  - In‑memory H2 database: `jdbc:h2:mem:testdb` (user: `sa`, empty password).
  - Schema is initialized from `accounts/src/main/resources/schema.sql` on startup.
  - H2 console is enabled at `/h2-console`.

- **Endpoints**
  - `GET /sayhello` → returns a simple `"Hi World!"` response (health check / smoke test).

### Tracking pushed code

High‑level details about pushes to this repository are tracked in the file:

- `Code update status.md` – minimal notes about what was pushed and when.

Going forward, commit messages for this repo are agreed with the maintainer before pushing to GitHub.
