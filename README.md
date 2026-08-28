# Learning Management System (LMS)

A robust and scalable **Learning Management System (LMS)** built using **Java, Spring Boot, Spring Data JPA, Spring Security, OAuth2/OIDC, JMS, and PostgreSQL**.

The application provides functionality for managing courses, student enrollments, assignments, submissions, role-based access, asynchronous messaging, notifications, logging, and performance monitoring.

---

## 📌 Project Overview

The Learning Management System is designed to support three primary user roles:

* **ADMIN**
* **INSTRUCTOR**
* **STUDENT**

The system allows instructors to create and manage courses and assignments, students to enroll in courses and submit assignments, and administrators to manage users and administrative operations.

The application follows a layered architecture:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

Additional cross-cutting and asynchronous components include:

```text
Spring Security
Logging
AOP Performance Monitoring
JMS Messaging
Notification Processing
```

---

# 🛠️ Technology Stack

| Technology        | Purpose                          |
| ----------------- | -------------------------------- |
| Java              | Programming Language             |
| Spring Boot       | Application Framework            |
| Spring Web        | REST API Development             |
| Spring Data JPA   | Database Access                  |
| Hibernate         | ORM Framework                    |
| PostgreSQL        | Relational Database              |
| Spring Validation | Request Validation               |
| Spring Security   | Authentication and Authorization |
| OAuth2 / OIDC     | Single Sign-On                   |
| JMS               | Asynchronous Messaging           |
| Apache Artemis    | JMS Message Broker               |
| Spring AOP        | Performance Monitoring           |
| SLF4J + Logback   | Application Logging              |
| Maven             | Dependency Management            |
| Lombok            | Reducing Boilerplate Code        |

---

# 🏗️ Project Architecture

```text
                         ┌─────────────────┐
                         │      USER       │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │ Spring Security │
                         │   OAuth2/OIDC   │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │   Controller    │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │    Service      │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │   Repository    │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │   PostgreSQL    │
                         └─────────────────┘
```

The application also uses AOP for monitoring service execution time.

```text
Service Method
      ↓
Performance Aspect
      ↓
Measure Execution Time
      ↓
Write Performance Log
```

---

# 📂 Project Structure

```text
lms
│
├── pom.xml
│
└── src
    └── main
        │
        ├── java
        │   └── com
        │       └── bridgelabz
        │           └── lms
        │
        │               ├── LmsApplication.java
        │
        │               ├── config
        │               │   ├── SecurityConfig.java
        │               │   └── JmsConfig.java
        │
        │               ├── controller
        │               │   ├── CourseController.java
        │               │   ├── EnrollmentController.java
        │               │   ├── AssignmentController.java
        │               │   ├── SubmissionController.java
        │               │   └── AdminController.java
        │
        │               ├── dto
        │               │   ├── request
        │               │   │   ├── CourseRequest.java
        │               │   │   ├── EnrollmentRequest.java
        │               │   │   ├── AssignmentRequest.java
        │               │   │   └── SubmissionRequest.java
        │               │   │
        │               │   ├── response
        │               │   │   ├── CourseResponse.java
        │               │   │   ├── EnrollmentResponse.java
        │               │   │   ├── AssignmentResponse.java
        │               │   │   ├── SubmissionResponse.java
        │               │   │   └── UserResponse.java
        │               │   │
        │               │   └── event
        │               │       └── AssignmentSubmittedEvent.java
        │
        │               ├── entity
        │               │   ├── User.java
        │               │   ├── Course.java
        │               │   ├── Enrollment.java
        │               │   ├── Assignment.java
        │               │   └── Submission.java
        │
        │               ├── enums
        │               │   ├── Role.java
        │               │   ├── CourseStatus.java
        │               │   ├── EnrollmentStatus.java
        │               │   └── SubmissionStatus.java
        │
        │               ├── repository
        │               │   ├── UserRepository.java
        │               │   ├── CourseRepository.java
        │               │   ├── EnrollmentRepository.java
        │               │   ├── AssignmentRepository.java
        │               │   └── SubmissionRepository.java
        │
        │               ├── service
        │               │   ├── CourseService.java
        │               │   ├── EnrollmentService.java
        │               │   ├── AssignmentService.java
        │               │   ├── SubmissionService.java
        │               │   ├── NotificationService.java
        │               │   │
        │               │   └── impl
        │               │       ├── CourseServiceImpl.java
        │               │       ├── EnrollmentServiceImpl.java
        │               │       ├── AssignmentServiceImpl.java
        │               │       ├── SubmissionServiceImpl.java
        │               │       └── NotificationServiceImpl.java
        │
        │               ├── mapper
        │               │   ├── CourseMapper.java
        │               │   ├── EnrollmentMapper.java
        │               │   ├── AssignmentMapper.java
        │               │   └── SubmissionMapper.java
        │
        │               ├── exception
        │               │   ├── ResourceNotFoundException.java
        │               │   ├── BusinessException.java
        │               │   ├── ErrorResponse.java
        │               │   └── GlobalExceptionHandler.java
        │
        │               ├── aspect
        │               │   └── PerformanceAspect.java
        │
        │               └── messaging
        │                   ├── producer
        │                   │   └── AssignmentSubmissionProducer.java
        │                   │
        │                   └── consumer
        │                       └── AssignmentSubmissionConsumer.java
        │
        └── resources
            ├── application.properties
            └── logback-spring.xml
```

---

# 👥 User Roles

## ADMIN

The administrator has access to administrative operations.

Example responsibilities:

* Manage users
* View system-level information
* Access administrative APIs

---

## INSTRUCTOR

The instructor can manage courses and assignments.

Example responsibilities:

* Create courses
* Update courses
* Create assignments
* View student submissions

---

## STUDENT

Students can participate in courses and submit assignments.

Example responsibilities:

* View available courses
* Enroll in courses
* View assignments
* Submit assignments

---

# 🔐 Security and Authorization

The application uses Spring Security for authentication and role-based authorization.

The supported roles are:

```text
ADMIN
INSTRUCTOR
STUDENT
```

Example access control:

| Endpoint                                 | Allowed Role      |
| ---------------------------------------- | ----------------- |
| `POST /api/courses`                      | ADMIN, INSTRUCTOR |
| `PUT /api/courses/{id}`                  | ADMIN, INSTRUCTOR |
| `POST /api/courses/{id}/enroll`          | ADMIN, STUDENT    |
| `POST /api/courses/{id}/assignments`     | ADMIN, INSTRUCTOR |
| `POST /api/assignments/{id}/submissions` | ADMIN, STUDENT    |
| `GET /api/admin/**`                      | ADMIN             |

OAuth2/OIDC can be used for Single Sign-On authentication.

---

# 📚 Core Features

## 1. Course Management

Instructors and administrators can manage courses.

Features include:

* Create a course
* Update course details
* Retrieve courses
* Manage course status

---

## 2. Student Enrollment

Students can enroll in available courses.

The system manages enrollment information and enrollment status.

---

## 3. Assignment Management

Instructors can create assignments for courses.

Features include:

* Create assignments
* Retrieve assignments by course
* Manage assignment information

---

## 4. Assignment Submission

Students can submit assignments.

The system validates the submission and prevents duplicate submissions when required.

```text
Student
   ↓
Submit Assignment
   ↓
SubmissionController
   ↓
SubmissionService
   ↓
SubmissionRepository
   ↓
PostgreSQL
```

---

# 📩 JMS Event Flow

The application uses JMS for asynchronous event processing.

When a student submits an assignment:

```text
Student submits Assignment
            │
            ▼
     SubmissionService
            │
            ▼
      Save Submission
            │
            ▼
AssignmentSubmittedEvent
            │
            ▼
       JMS Producer
            │
            ▼
  assignment.submitted Queue
            │
            ▼
       JMS Consumer
            │
            ▼
   NotificationService
            │
            ▼
   Notification Processed
```

This architecture separates the assignment submission process from notification processing.

---

# ⚡ Performance Monitoring with AOP

The application uses Spring AOP to monitor service-layer method execution time.

```text
Service Method Called
        │
        ▼
PerformanceAspect
        │
        ▼
Start Timer
        │
        ▼
Execute Service Method
        │
        ▼
Stop Timer
        │
        ▼
Log Execution Time
```

Example log:

```text
PERFORMANCE: CourseServiceImpl.createCourse(..) executed in 45 ms
```

---

# 📝 Logging

The application uses:

```text
SLF4J + Logback
```

Logs are generated for:

* Important application operations
* Service execution
* JMS event publishing
* JMS event consumption
* Notification processing
* Errors and exceptions

Example:

```text
2026-08-28 10:30:00 INFO
Assignment submission event published successfully.
```

Application logs can be stored in:

```text
logs/lms.log
```

Sensitive information such as passwords, tokens, and secrets should never be logged.

---

# 🗄️ Database Configuration

The application uses PostgreSQL.

Create a database:

```sql
CREATE DATABASE lms_db;
```

Configure your database connection in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lms_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace:

```text
YOUR_PASSWORD
```

with your PostgreSQL password.

---

# ⚙️ Application Configuration

Example `application.properties` configuration:

```properties
spring.application.name=lms

# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/lms_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging
logging.level.com.bridgelabz.lms=INFO

# JMS
spring.artemis.mode=embedded

# OAuth2 / OIDC
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=openid,profile,email
```

> Never commit real database passwords, OAuth client secrets, or other sensitive credentials to a public repository.

---

# 🚀 Running the Application

## Prerequisites

Install the following:

* Java 17 or later
* Maven
* PostgreSQL
* IntelliJ IDEA or another Java IDE

---

## Step 1: Clone the Repository

```bash
git clone <your-repository-url>
```

Navigate into the project:

```bash
cd lms
```

---

## Step 2: Create the Database

```sql
CREATE DATABASE lms_db;
```

---

## Step 3: Configure `application.properties`

Update:

```properties
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

Configure your OAuth2 credentials if OAuth2 login is enabled.

---

## Step 4: Build the Project

```bash
mvn clean install
```

---

## Step 5: Run the Application

```bash
mvn spring-boot:run
```

Or run:

```text
LmsApplication.java
```

from IntelliJ IDEA.

---

# 🧪 Testing the Application

A typical LMS flow can be tested as follows:

```text
1. Start the application
        ↓
2. Authenticate the user
        ↓
3. Verify user role
        ↓
4. INSTRUCTOR creates a course
        ↓
5. STUDENT enrolls in the course
        ↓
6. INSTRUCTOR creates an assignment
        ↓
7. STUDENT submits the assignment
        ↓
8. Submission is saved in PostgreSQL
        ↓
9. AssignmentSubmittedEvent is created
        ↓
10. JMS Producer publishes the event
        ↓
11. JMS Consumer receives the event
        ↓
12. NotificationService processes the event
        ↓
13. Check Logging output
        ↓
14. Check AOP performance logs
```

---

# 🌐 API Modules

The application contains the following API modules:

```text
/api/courses
/api/enrollments
/api/assignments
/api/submissions
/api/admin
```

The exact endpoint paths and request bodies depend on the controller implementations.

---

# 🧩 Error Handling

The application uses centralized exception handling.

Main exception components:

```text
ResourceNotFoundException
BusinessException
ErrorResponse
GlobalExceptionHandler
```

Example error response:

```json
{
  "timestamp": "2026-08-28T10:30:00",
  "status": 404,
  "message": "Course not found"
}
```

---

# 🔄 Application Flow

## Course Creation

```text
INSTRUCTOR
     │
     ▼
CourseController
     │
     ▼
CourseService
     │
     ▼
CourseRepository
     │
     ▼
PostgreSQL
```

---

## Enrollment Flow

```text
STUDENT
     │
     ▼
EnrollmentController
     │
     ▼
EnrollmentService
     │
     ▼
EnrollmentRepository
     │
     ▼
PostgreSQL
```

---

## Assignment Submission Flow

```text
STUDENT
     │
     ▼
SubmissionController
     │
     ▼
SubmissionService
     │
     ├──────────────► PostgreSQL
     │
     ▼
AssignmentSubmittedEvent
     │
     ▼
JMS Producer
     │
     ▼
assignment.submitted
     │
     ▼
JMS Consumer
     │
     ▼
NotificationService
```

---

# 🔮 Future Enhancements

Possible future improvements include:

* Email notifications
* Push notifications
* File uploads for assignments
* Assignment grading
* Student progress tracking
* Course completion certificates
* JWT-based authentication
* Redis caching
* Docker containerization
* CI/CD pipeline
* Swagger/OpenAPI documentation
* Monitoring and health checks
* Dead Letter Queue support
* Message retry and redelivery
* Unit and integration testing
* Frontend application using React or Angular

---

# 📋 Project Status

## Completed Core Modules

```text
Project Setup                  ✅
Entities                       ✅
Enums                          ✅
Repositories                   ✅
DTOs                           ✅
Validation                     ✅
Mappers                        ✅
Services                       ✅
Service Implementations        ✅
REST Controllers               ✅
Exception Handling             ✅
```

## Advanced Modules

```text
Logging                        ✅ Implemented
AOP Performance Monitoring     ✅ Implemented
JMS Event Structure            ✅ Implemented
JMS Producer                   ✅ Implemented
JMS Consumer                   ✅ Implemented
Notification Processing        ✅ Implemented
Security Configuration         ✅ Implemented
OAuth2/OIDC Configuration      ⚙️ Requires Provider Credentials
Role Authorization             ⚙️ Requires Final Testing
End-to-End Testing             ⚙️ Pending Verification
```

---

# 👨‍💻 Author

**Saravanan**

---

# 📄 License

This project is created for educational and learning purposes.

---

## ⭐ Final Architecture

```text
                         LMS APPLICATION

                              USER
                               │
                               ▼
                     ┌──────────────────┐
                     │ OAuth2 / OIDC    │
                     │ Spring Security  │
                     └────────┬─────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │ Role Authorization│
                     └────────┬─────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │   Controllers    │
                     └────────┬─────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │     Services     │◄──── AOP Monitoring
                     └────────┬─────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │   Repositories   │
                     └────────┬─────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │   PostgreSQL     │
                     └──────────────────┘


              ASYNCHRONOUS ASSIGNMENT FLOW

                     Assignment Submission
                              │
                              ▼
                     AssignmentSubmittedEvent
                              │
                              ▼
                         JMS Producer
                              │
                              ▼
                    assignment.submitted
                              │
                              ▼
                         JMS Consumer
                              │
                              ▼
                     NotificationService
                              │
                              ▼
                           Logging
```
