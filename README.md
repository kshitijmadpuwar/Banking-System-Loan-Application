# 🏦 Banking System with Loan Application (Spring Boot)

## 📌 Overview
This is a backend banking application developed using Spring Boot that simulates real-world banking operations along with a loan management system.

The application supports account management, secure transactions, authentication, and multiple loan types such as home loan, car loan, and gold loan.

The main goal of this project was to understand how scalable backend systems are designed using Java and Spring Boot.

---

## 🚀 Features

### 🔹 Account Management
- Create and manage bank accounts  
- Deposit and withdraw money  
- Check account balance  

### 🔹 Transaction System
- Secure fund transactions  
- Maintain transaction history  
- Validation for insufficient balance and invalid operations  

### 🔹 Loan Management
- Apply for different loan types:
  - Home Loan  
  - Car Loan  
  - Gold Loan  
- Basic eligibility and approval logic  
- Loan status tracking  

### 🔹 Authentication & Security
- User authentication (login system)  
- Secured endpoints using Spring Security (basic)  

### 🔹 Exception Handling
- Global exception handling using `@ControllerAdvice`  
- Custom exceptions:
  - InsufficientBalanceException  
  - NegativeAmountException  
  - LoanNotApprovedException  

---

## 🛠️ Tech Stack

**Backend:**  
Java, Spring Boot, Spring MVC, Spring Data JPA  

**Security:**  
Spring Security (basic authentication)  

**Database:**  
MySQL  

**ORM Tool:**  
Hibernate  

**Build Tool:**  
Maven  

---

## 🧠 What I Learned

- Building REST APIs using Spring Boot  
- Designing layered architecture (Controller → Service → Repository)  
- Implementing authentication using Spring Security  
- Handling transactions and business logic  
- Managing multiple modules (account, transaction, loan)  
- Writing custom exceptions and global exception handling  
- Structuring scalable backend applications  

---

## 📂 Project Structure

- `controller` → Handles API requests  
- `service` → Business logic (account, transaction, loan)  
- `repository` → Database operations  
- `entity` → Database models  
- `security` → Authentication and configuration  
- `exception` → Custom exceptions and global handler  

---

## ▶️ How to Run

1. Clone the repository  
2. Open in Eclipse / IntelliJ  
3. Configure MySQL in `application.properties`  
4. Run the Spring Boot application  
5. Test APIs using Postman  

---

## 🔗 API Endpoints (Sample)

### Account
- `POST /accounts` → Create account  
- `GET /accounts/{id}` → Get account details  

### Transactions
- `POST /transactions/deposit`  
- `POST /transactions/withdraw`  

### Loan
- `POST /loans/apply`  
- `GET /loans/status/{id}`  

### Auth
- `POST /auth/login`  

---

## ⚙️ Sample Flow

- User registers / logs in  
- Creates bank account  
- Performs deposit/withdraw transactions  
- Applies for loan (home/car/gold)  
- System validates and updates loan status  

---

## 🚧 Future Improvements

- JWT-based authentication  
- Role-based authorization (Admin/User)  
- Payment gateway integration  
- Microservices architecture  
- Deployment on cloud (AWS / Render)  

---

## 👨‍💻 Author

Kshitij Madpuwar
