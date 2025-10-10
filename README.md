For testing locally:

Linux / macOS

export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/skopjemarathon
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=6vNb9PZb
export APP_JWT_SECRET=superSecretKey123superSecretKey123
./gradlew bootRun

Windows PowerShell

$env:SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/skopjemarathon"
$env:SPRING_DATASOURCE_USERNAME="postgres"
$env:SPRING_DATASOURCE_PASSWORD="6vNb9PZb"
$env:APP_JWT_SECRET="superSecretKey123superSecretKey123"
.\gradlew bootRun

Windows CMD

set SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/skopjemarathon
set SPRING_DATASOURCE_USERNAME=postgres
set SPRING_DATASOURCE_PASSWORD=6vNb9PZb
set APP_JWT_SECRET=superSecretKey123superSecretKey123
gradlew bootRun

Prerequisites: Docker installed and Docker Compose installed 

Steps:
git clone https://github.com/ilijana123/skopje-marathon.git
cd skopje-marathon
Build and start the services:    docker-compose up --build
The application will be available at:  http://localhost:8081
PostgreSQL will be running inside a container on port 5432.
Database name: skopjemarathon
Username: postgres
Password: 6vNb9PZb

P.S.: Not ideal having the credentials here, but they ae not exposed in the code(.env added to .gitignore)


https://ws3333-3182.postman.co/workspace/WS-Workspace~1c54f13a-b90a-410f-bfc1-876b5c0badd3/collection/41348129-2d84f71d-b528-4a0c-a284-05f12a921e30?action=share&creator=41348129&active-environment=41348129-567601e0-9947-491f-97b3-4df49b209a7b
https://app.getpostman.com/join-team?invite_code=3e0987138cb52cd66efeedb843d15231e662af3eb4ca27d9426a758ab573cdab&target_code=9cfb525eb0b2cdd5a224c3bdb3907660
(Added a Swagger, but still link to the Postman collection)
For testing in Swagger: If you want to test the review-controller for adding comment and rating for a race or race-controller to get all the paid races, you must login first(login-controller) and use the generated jwt token for authorization.

Starting number generated sequentially, the registration number generation is random.

Payment Simulation
The payment process is simulated (no real transactions) and each payment attempt has a 50% chance of success. A contestant can retry up to 3 times and if all 3 attempts fail, the payment status is set to FAILED. If any attempt succeeds, the status is set to SUCCESS and a starting number is generated.

Used MapStruct for automatic mapping.

<img width="776" height="818" alt="image" src="https://github.com/user-attachments/assets/5f269c4e-d7ab-4c11-9396-a690369490d5" />
