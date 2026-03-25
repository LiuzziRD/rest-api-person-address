# Person Address API

## 📌 Description

This project is a REST API developed using **Java 21 + Spring Boot** to manage people and their addresses.

The API allows creating, listing, searching and deleting persons, as well as registering multiple addresses for each person.

This project was developed for study purposes and academic project, following good practices used in backend development.

---

## 🚀 Technologies

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger / OpenAPI
* Bean Validation
* Global Exception Handler

---

## 📂 Project Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

### Packages

* controller → API endpoints
* service → business rules
* repository → database access
* database.model → entities
* exception → custom exceptions
* handler → global exception handler
* utils → error response
* validation → bean validation

---

## 📌 Features

* Create person
* List all persons
* Find person by id
* Delete person
* Register addresses
* OneToMany relationship
* Validation with annotations
* Custom Exception
* Global Exception Handler
* Standard Error Response
* Swagger documentation

---

## 📌 Endpoints

### Person

POST /persons → Create a new person
GET /persons → List all persons
GET /persons/{id} → Find person by id
DELETE /persons/{id} → Delete person

### Address

POST /addresses → Create address
GET /addresses → List addresses
GET /addresses/{id} → Find address
DELETE /addresses/{id} → Delete address

---

## 📌 Validation

The project uses Bean Validation:

@NotBlank
@NotNull
@Valid

Validation errors are handled by GlobalExceptionHandler.

---

## 📌 Exception Handling

Custom exceptions:

* NotFoundException

Global handler:

* GlobalExceptionHandler

Standard error response:

* ErrorResponse

Example:

{
"status": 400,
"error": "Validation Error",
"message": "Name is required",
"path": "/persons"
}

---

## 📌 Database

Relationship:

Person 1 → N Address

Tables:

* person
* address
* person_phone

JPA / Hibernate used for ORM.

---

## 📌 Swagger

Swagger UI available at:

http://localhost:8080/swagger-ui.html

or

http://localhost:8080/swagger-ui/index.html

---

## ▶ How to run

1. Configure database in application.yaml
2. Run Spring Boot
3. Open Swagger
4. Test endpoints

---

## 👨‍💻 Author

Rogerio Rissutti Liuzzi Junior
Computer Science Student
Backend Developer
