This project is a robust, BDD-driven test automation framework designed to validate the Automation Exercise REST API. 
Developed by a Scrum team of 8, the framework ensures the reliability of core business logic such as product retrieval, brand management, and user authentication.


Framework Architecture
The framework follows a modular Service Object Model (SOM) to separate API configurations, request building, and validation logic.

Tech Stack
Language: Java 17

API Client: RestAssured

Test Runner: JUnit 5 / Cucumber

Mocking: Mockito (for Unit Testing utility logic)

Build Tool: Maven

Prerequisites
JDK 17 or higher

Maven 3.8.1+

IntelliJ IDEA (recommended)

Features
. Automated tests for 3+ API endpoints

. Happy & sad path coverage

. Unit tests for helper logic using Mockito

. Optional Cucumber BDD support

. Clean, modular framework structure

. GitHub repo with feature branches & regular commits

Project Structure


Endpoints Covered
At least three endpoints are fully validated, including:

1. GET /productsList
Validate status code

Validate response schema

Validate product fields (id, name, price, brand, category)

2. POST /verifyLogin
Happy path: valid email + password

Sad path: invalid credentials

Validate error messages

3. POST /createAccount
Validate required fields

Validate error handling

Validate success response


