Skopje Marathon API
Skopje Marathon API is a Spring Boot backend application designed to manage marathon registrations, race details, payments, and reviews. The application is fully containerized using Docker and Docker Compose for easy setup and deployment.

🚀 Tech Stack
Backend: Java, Spring Boot

Security: Spring Security with JWT Authentication

Database: PostgreSQL

Mapping: MapStruct (automatic DTO to entity mapping)

Containerization: Docker & Docker Compose

🛠 Prerequisites
Before running the application, ensure the following tools are installed:

Docker

Docker Compose

Git

⚙️ Setup and Installation
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
Note: Ensure .env is listed in your .gitignore to avoid committing sensitive credentials.

🏃 Running the Application
Build and Start
Run these commands in your terminal to build the application and launch the containers:

Bash

# Build the Spring Boot JAR file (skipping tests)
./gradlew clean build -x test

# Start the services in detached mode
docker-compose up -d --build
Application Access
API Base URL: http://localhost:8081

PostgreSQL Database: localhost:5432

🧪 API Documentation and Testing
Postman Collections
You can test the endpoints using the following links:

Postman Collection

Join Postman Team Workspace

Authentication
The application uses JWT-based authentication. To access protected endpoints (such as the review-controller or race-controller for paid races):

Use the login-controller to obtain a token.

Include the token in your request headers: Authorization: Bearer <your_token_here>

💡 Business Logic
Payment Simulation
The payment process is simulated with a 3-retry logic:

Each attempt has a 50% success rate.

A contestant can retry up to 3 times.

Success: If any attempt succeeds, the status is set to SUCCESS and a starting number is generated.

Failure: If all 3 attempts fail, the status is set to FAILED.

Number Generation
Registration Number: Randomly generated upon registration.

Starting Number: Sequentially generated only after a successful payment.

Database Seeding
The application automatically populates the category table with default values upon startup via an internal SQL execution script.

🛠 Useful Docker Commands
View Logs: docker-compose logs -f

Stop Services: docker-compose down

Restart Services: docker-compose restart
