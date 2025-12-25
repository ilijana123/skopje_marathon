Skopje Marathon API
This is a Spring Boot application designed to manage marathon registrations, race details, and reviews. It uses PostgreSQL for data persistence and is fully containerized with Docker.

🚀 Tech Stack
Backend: Java, Spring Boot

Database: PostgreSQL

Mapping: MapStruct (for automatic DTO mapping)

Containerization: Docker & Docker Compose

Security: JWT (JSON Web Token)

🛠 Prerequisites
Before running the application, ensure you have the following installed:

Docker

Docker Compose

Git

⚙️ Setup & Installation
1. Clone the Repository
Bash

git clone https://github.com/ilijana123/skopje-marathon.git
cd skopje-marathon
2. Configure Environment Variables
Create a file named .env in the root directory of the project and paste the following configuration:

Code snippet

POSTGRES_DB=skopjemarathon
POSTGRES_USER=postgres
POSTGRES_PASSWORD=6vNb9PZb
POSTGRES_HOST=db
POSTGRES_PORT=5432

SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/skopjemarathon
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=6vNb9PZb

APP_JWT_SECRET=superSecretKey123superSecretKey123
🏃 Running the Application
Follow these steps to build the JAR file and start the containers:

Build the Project
Run the Gradle wrapper to build the application while skipping tests:

Bash

./gradlew clean build -x test
Start Services
Launch the application and the database in detached mode:

Bash

docker-compose up -d --build
API URL: http://localhost:8081

Database: Running on localhost:5432

📖 API Documentation & Testing
Postman
You can access the API collection and environment via the links below:

View Postman Collection
Join Postman Team

Authentication
Certain endpoints (like review-controller or race-controller for paid races) require authorization:

 Key Features & Logic
 Payment Simulation
The payment process is simulated with a logic-based outcome:

Success Rate: Each attempt has a 50% chance of success.

Retries: A contestant can retry up to 3 times.

Outcome: * If any attempt succeeds: Status is set to SUCCESS and a starting number is generated.

If all 3 attempts fail: Status is set to FAILED.

 Identifiers
Registration Number: Generated randomly.

Starting Number: Generated sequentially upon successful payment.

Database Seeding
On application startup, the category table is automatically seeded with default values via an internal SQL execution script.

<img width="776" height="818" alt="image" src="https://github.com/user-attachments/assets/5f269c4e-d7ab-4c11-9396-a690369490d5" />
