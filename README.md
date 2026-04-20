# Hospital Management System (Spring Boot + JWT)

## Overview

This is a backend project built using Spring Boot, Spring Security, JWT, and MySQL.

The project is designed as a simple and practical implementation to understand:

- Spring Boot project structure
- JWT Authentication
- Secured REST APIs
- CRUD operations
- Clean layered architecture

This is a mini-project focused on learning backend development concepts.

## Tech Stack

- Java 17
- Spring Boot 3.2.3
- Spring Security
- JWT (jjwt 0.11.5)
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Modules

- **Auth Module** - Register, Login, JWT Token Generation
- **Patient Module** - Full CRUD Operations

## API Endpoints

### Auth APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

### Patient APIs (Secured - Requires Bearer Token)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/patients | Add patient |
| GET | /api/patients | Get all patients |
| GET | /api/patients/{id} | Get patient by ID |
| PUT | /api/patients/{id} | Update patient |
| DELETE | /api/patients/{id} | Delete patient |

## Setup

1. Create MySQL database: `hospital_db`
2. Update `application.properties` with your DB credentials
3. Run the project
4. Test APIs in Postman

## Authorization
