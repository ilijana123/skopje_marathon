# Skopje Marathon API
Skopje Marathon API is a Spring Boot backend application designed to manage marathon registrations, race details, payments, and reviews. 
[Frontend built with React + TS + Material UI](https://github.com/ilijana123/skopje_marathon_frontend)
## Tech Stack
- Backend: *Java*, *Spring Boot*
- Security: Spring Security with JWT Authentication
- Database: PostgreSQL
- Mapping: MapStruct
- Containerization: Docker & Docker Compose

## Prerequisites
- Docker
- Docker Compose
- Git

### 1. Clone the Repository
```
git clone https://github.com/ilijana123/skopje-marathon.git
```
```
cd skopje-marathon
```
### 2. Configure Environment Variables

- Create a file named .env in the root directory of the project and paste the following configuration:
```
POSTGRES_DB=skopjemarathon
POSTGRES_USER=postgres
POSTGRES_PASSWORD=6vNb9PZb
POSTGRES_HOST=db
POSTGRES_PORT=5432

SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/skopjemarathon
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=6vNb9PZb

APP_JWT_SECRET=superSecretKey123superSecretKey123
```
> [!WARNING]: Ensure .env is listed in your .gitignore to avoid committing sensitive credentials.


Build and Start
```
./gradlew clean build -x test
```
```
docker-compose up -d --build
```
### Application Access
- API Base URL: http://localhost:8081
- PostgreSQL Database: localhost:5432

## API Documentation and Testing
Postman Collections
You can test the endpoints using the following links:

- [Postman Collection](https://ws3333-3182.postman.co/workspace/WS-Workspace~1c54f13a-b90a-410f-bfc1-876b5c0badd3/collection/41348129-2d84f71d-b528-4a0c-a284-05f12a921e30?action=share&creator=41348129&active-environment=41348129-567601e0-9947-491f-97b3-4df49b209a7b)

- Swagger

# Business Logic
Payment Simulation with a 3-retry logic:
- Each attempt has a 50% success rate.
- A contestant can retry up to 3 times.
- Success: If any attempt succeeds, the status is set to SUCCESS and a starting number is generated.
- Failure: If all 3 attempts fail, the status is set to FAILED.

### Number Generation
- Registration Number: Randomly generated upon registration.
- Starting Number: Sequentially generated only after a successful payment.

### Database Seeding
The application automatically populates the category table with default values upon startup via an internal SQL execution script.

# Useful Docker Commands
- View Logs: docker-compose logs -f
- Stop Services: docker-compose down
- Restart Services: docker-compose restart
