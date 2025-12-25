Skopje Marathon API

Skopje Marathon API is a Spring Boot backend application designed to manage marathon registrations, race details, payments, and reviews. The application uses PostgreSQL for data persistence and is fully containerized using Docker and Docker Compose.

Tech Stack
Backend

Java

Spring Boot

Spring Security (JWT authentication)

Database

PostgreSQL

Mapping

MapStruct (automatic DTO to entity mapping)

Containerization

Docker

Docker Compose

Prerequisites

Before running the application, ensure the following tools are installed:

Docker

Docker Compose

Git

Setup and Installation
Clone the Repository
git clone https://github.com/ilijana123/skopje-marathon.git
cd skopje-marathon

Configure Environment Variables

Create a .env file in the root directory of the project and add the following configuration:

POSTGRES_DB=skopjemarathon
POSTGRES_USER=postgres
POSTGRES_PASSWORD=6vNb9PZb
POSTGRES_HOST=db
POSTGRES_PORT=5432

SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/skopjemarathon
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=6vNb9PZb

APP_JWT_SECRET=superSecretKey123superSecretKey123


Important:

Do not commit the .env file to version control

Ensure .env is listed in .gitignore

Running the Application
Build the Project

Build the Spring Boot JAR file while skipping tests:

./gradlew clean build -x test

Start Docker Services

Start the backend and PostgreSQL database using Docker Compose:

docker-compose up -d --build

Application Access

API Base URL:
http://localhost:8081

PostgreSQL Database:
localhost:5432

API Documentation and Testing
Postman

The API can be tested using Postman.

Postman Collection: https://ws3333-3182.postman.co/workspace/WS-Workspace~1c54f13a-b90a-410f-bfc1-876b5c0badd3/collection/41348129-2d84f71d-b528-4a0c-a284-05f12a921e30?action=share&creator=41348129&active-environment=41348129-567601e0-9947-491f-97b3-4df49b209a7b

Postman Team Workspace: https://app.getpostman.com/join-team?invite_code=3e0987138cb52cd66efeedb843d15231e662af3eb4ca27d9426a758ab573cdab&target_code=9cfb525eb0b2cdd5a224c3bdb3907660

Authentication and Authorization

The application uses JWT-based authentication.

Some endpoints require authorization, including:

review-controller

race-controller (for paid races)

The JWT token must be included in the Authorization header:

Authorization: Bearer <token>

Payment Simulation Logic

The payment process is simulated using business logic rules.

Each payment attempt has a 50 percent chance of success

A contestant may retry payment up to three times

Payment Outcome

If any attempt succeeds:

Registration status is set to SUCCESS

A starting number is generated

If all three attempts fail:

Registration status is set to FAILED

Identifiers and Number Generation

Registration number is generated randomly during registration

Starting number is generated sequentially after successful payment

Database Seeding

On application startup:

The category table is automatically populated with default values

Seeding is performed via an internal SQL execution script

Docker Services Overview

Backend service: Spring Boot application

Database service: PostgreSQL

Internal Docker network hostname: db

Useful Docker Commands

View logs:

docker-compose logs -f


Stop services:

docker-compose down
