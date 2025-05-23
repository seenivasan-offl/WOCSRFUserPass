# WOCSRFUserPass

A simple Spring Boot REST API that handles **User Registration** and **Login** with password encryption using **BCrypt**. This project uses Spring Security (custom implementation), JPA for database operations, and follows RESTful conventions.

## Features

- User registration with BCrypt password hashing
- User login validation
- Retrieve all registered users
- Secure handling of password storage
- Basic CSRF protection can be extended later

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (custom password handling)
- H2 / MySQL (or your configured DB)
- Maven / Gradle

---

## Endpoints

| Method | Endpoint         | Description               | Payload Example             |
|--------|------------------|---------------------------|-----------------------------|
| GET    | `/api/users`     | Get all registered users  | –                           |
| POST   | `/api/register`  | Register a new user       | `{ "username": "user", "password": "pass" }` |
| POST   | `/api/login`     | Login with credentials    | `{ "username": "user", "password": "pass" }` |

> Note: Password is stored securely with BCrypt, but the login function currently compares raw password — you should update it to use `passwordEncoder.matches(raw, encoded)` for production.

---

## Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle
- IDE (IntelliJ, Eclipse, VS Code)

### Running the Application

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/WOCSRFUserPass.git
   cd WOCSRFUserPass
