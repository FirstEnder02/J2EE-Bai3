# J2EE Spring Boot REST Application

## Overview
A Spring Boot 3.3.5 web application with Thymeleaf templates for managing books. Vietnamese language J2EE exercise project.

## Project Structure
```
src/
├── main/
│   ├── java/springtrap/
│   │   ├── springtrapApplication.java  # Main Spring Boot entry point
│   │   ├── controller/
│   │   │   ├── BookController.java     # CRUD operations for books
│   │   │   └── DemoController.java     # Demo page controller
│   │   ├── model/
│   │   │   ├── Book.java               # Book entity
│   │   │   └── Student.java            # Student entity
│   │   └── service/
│   │       └── BookService.java        # Book business logic
│   └── resources/
│       ├── application.properties      # Server config (port 5000)
│       └── templates/                  # Thymeleaf HTML templates
│           ├── books.html
│           ├── add-book.html
│           ├── edit-book.html
│           └── demo.html
```

## Running the Application
The application runs on port 5000 with:
```
./mvnw spring-boot:run
```

## Routes
- `/demo` - Demo page with student information
- `/books` - List all books
- `/books/add` - Add a new book
- `/books/edit/{id}` - Edit a book

## Technology Stack
- Java 17 (GraalVM)
- Spring Boot 3.3.5
- Thymeleaf templates
- Maven

## Recent Changes
- 2026-02-03: Configured for Replit environment
  - Set server port to 5000
  - Set server address to 0.0.0.0
  - Changed Java version from 21 to 17 for GraalVM compatibility
  - Fixed package/class name casing issues
