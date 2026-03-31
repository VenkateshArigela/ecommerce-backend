# 🛒 E-Commerce Full Stack Application

## 🚀 Overview

This project is a **Full Stack E-Commerce Application** built with a focus on **secure authentication and role-based access control**. It allows users to browse products and provides admin-level control for managing users and future product operations.

---

## 🔥 Features

### 👤 Authentication & Authorization

* User Registration & Login
* Password encryption using BCrypt
* JWT (JSON Web Token) based authentication
* Role-based access control (USER / ADMIN)

### 🛡️ Security

* Protected APIs using JWT Filter
* Token validation for every request
* Secure admin promotion (only ADMIN can promote users)

### 📦 Product Module

* View products (public access)
* Backend ready for:

  * Add Product (Admin)
  * Update Product (Admin)
  * Delete Product (Admin)

### 🌐 Frontend

* Login & Register UI
* Token stored in localStorage
* API integration with backend
* Dynamic navigation based on login state

---

## 🏗️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* JWT (io.jsonwebtoken)
* JPA / Hibernate
* MySQL

### Frontend

* HTML
* CSS (Bootstrap)
* JavaScript

---

## 🔐 Authentication Flow

1. User logs in with email & password
2. Backend generates JWT token (contains email + role)
3. Token stored in browser (localStorage)
4. Every request sends token in header:

   ```
   Authorization: Bearer <token>
   ```
5. JwtFilter validates token before allowing access

---

## 👑 Admin Flow

* First admin is created manually via database
* After that:

  * Admin can promote users to ADMIN
  * Future: Admin-only product management

---

## 📂 Project Structure

```
ecommerce-backend
│
├── auth
├── controller
├── service
├── repository
├── security
├── util
├── exception
│
└── resources
    ├── static (HTML frontend)
    └── application.properties
```

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone https://github.com/your-username/ecommerce-backend.git
```

### 2. Configure database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the application

```
mvn spring-boot:run
```

### 4. Access application

```
http://localhost:8080/login.html
```

---

## 🧠 Future Enhancements

* Shopping Cart functionality
* Order management system
* Payment integration
* Admin dashboard UI
* Improved frontend design

---

## 💡 Key Learnings

* Implementing JWT authentication
* Securing APIs using filters
* Role-based authorization
* Full stack integration

---

## 👨‍💻 Author

Venkatesh
