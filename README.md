# Ecommerce Backend

A Spring Boot based backend application for managing products with secure authentication using JWT.

---

## 🚀 Features

- Product CRUD APIs (Create, Read, Update, Delete)
- MySQL database integration
- JWT Authentication & Authorization
- Secure REST APIs
- Layered architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Maven

---

## 📂 Project Structure

- controller → Handles API requests
- service → Business logic
- repository → Database operations
- entity → Database models
- dto → Data transfer objects
- security → JWT & security configuration

---

## 🔐 Authentication

- User login with username and password
- JWT token generation
- Protected APIs using Bearer Token

---

## 📌 API Endpoints

### Auth
- POST /auth/login → Generate JWT token

### Products
- GET /products → Get all products
- POST /products → Add product
- PUT /products/{id} → Update product
- DELETE /products/{id} → Delete product

---

## ⚙️ Setup Instructions

1. Clone the repository
2. Open in IntelliJ / any IDE
3. Configure MySQL in application.properties
4. Run the application
5. Test APIs using Postman

---

## 🧪 Testing

Use Postman and add header:

Authorization: Bearer <your_token>

---

## 📈 Future Improvements

- Role-based authentication (Admin/User)
- Pagination & sorting
- Swagger API documentation
- Docker deployment

---

## 👨‍💻 Author

Venkatesh
