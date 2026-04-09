PROJECT OVERVIEW

This project is a robust, BDD-driven test automation framework designed to validate the Automation Exercise REST API. 
Developed by a Scrum team of 8, the framework ensures the reliability of core business logic such as product retrieval, brand management, and user authentication.

🧱 Framework Architecture
The framework is built around:

Service Object Model (SOM) for clean separation of API logic

RestAssured for HTTP request/response handling

Cucumber BDD (optional) for human‑readable test scenarios

JUnit 5 for test execution

Mockito for unit testing helper utilities

Maven for dependency management and build automation

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

📌 Features

Automated tests for 3+ API endpoints

Happy & sad path coverage

Unit tests for helper logic using Mockito

Optional Cucumber BDD support

Clean, modular framework structure

GitHub repo with feature branches & regular commits


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


✔️ Test Coverage


Happy Path Tests

1.Valid requests return correct status codes

2.Response body contains expected fields

3.Schema validation

4.Data integrity checks

Sad Path Tests

1.Missing fields

2.Invalid data types

3.Incorrect credentials

4.Unsupported methods

5.Boundary value tests


▶️ Running the Framework

Install dependencies : mvn clean install

Run all tests : mvn test

Run Cucumber tests : mvn test -Dcucumber.filter.tags="@smoke"

Run unit tests only : mvn -Dtest=*UnitTest test



🧩 Extending the Framework
To add a new endpoint:

1.Create a new Client class under clients/

2.Add POJOs under pojos/

3.Add tests under tests/

4.(Optional) Add feature files under features/

5.Add unit tests under unit/

6.Create a feature branch and open a PR into dev

This ensures consistency and maintainability for future teams.


📌 Git Workflow

This project follows GitHub Flow:

main → stable, production-ready

dev → integration branch

Feature branches:

Gayathri-ProductReview

Kevin--Individual-Search

Zakir-Login

Rafid-SignUp-Delete

Anthony-Filtering

Mohammed-SearchAll

Josef-Subscription

Leonidas-ContactUs


📌 Scrum & Project Board

A GitHub projectboard was used with 7 columns:

Bugs

Product Backlog

Sprint Backlog

In Progress

In Review

Done

Notes (Goal + DoD)

Project Goal

Deliver a complete, maintainable API testing framework for AutomationExercise API within one sprint.

Definition of Done

Code committed & reviewed

Tests automated & passing

Unit tests included

README updated

Feature merged into dev

No critical bugs


📌 Class Diagram


👥 Contributors
Team of 8 Automation Test Engineers
Working collaboratively using Scrum methodology.










