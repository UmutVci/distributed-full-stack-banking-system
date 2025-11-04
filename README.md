# Banking System — Full-Stack Microservices Project

A distributed **banking management system** developed using **Spring Boot**, **Node.js (Express)**, and **Angular**, following a **microservice-based architecture**.  
The system provides secure user authentication, account management, and transaction processing with gRPC and REST communication between services.

---

## Architecture Overview

```
Frontend (Angular)
      │
      ▼
API Gateway (Node.js + Express)
      │
      ▼
 ┌────────────────────┬────────────────────┐
 │   Account Service  │ Transaction Service│
 │  (Spring Boot)     │   (Spring Boot)    │
 │  PostgreSQL + JPA  │     gRPC APIs      │
 └────────────────────┴────────────────────┘
```

---

## Features

- JWT-based authentication and authorization  
- gRPC and REST communication between microservices  
- API Gateway built with Node.js and Express for centralized routing and proxying  
- Account registration, login, and balance management  
- Transaction service for fund transfers with rollback on failure  
- PostgreSQL database integration using Spring Data JPA  
- Responsive Angular frontend with Tailwind CSS  
- Containerized deployment using Docker Compose  

---

## Technology Stack

| Layer | Technologies |
|-------|---------------|
| **Frontend** | Angular 17, Tailwind CSS |
| **API Gateway** | Node.js, Express, Axios |
| **Backend Services** | Spring Boot, gRPC, Spring Security, JPA |
| **Database** | PostgreSQL |
| **Authentication** | JWT Token-based Security |
| **Containerization** | Docker, Docker Compose |

---

## Core Components

### Account Service
- User registration and authentication endpoints (`/api/v1/auth/register`, `/api/v1/auth/login`)  
- Account details and balance retrieval (`/api/v1/accounts/me`)  
- JWT validation and Spring Security integration  
- Communication with the Transaction Service via gRPC  

### Transaction Service
- Handles money transfers between accounts  
- Ensures consistency with transaction rollback on failure  
- Uses PostgreSQL for transaction persistence  

### API Gateway
- Central communication hub between frontend and backend  
- Proxies REST and gRPC requests to the respective services  
- Validates and forwards JWT tokens  
- Routes:  
  - `/api/v1/auth/*`  
  - `/api/v1/accounts/*`  
  - `/api/v1/transactions/*`  

### Angular Frontend
- Login and registration forms with validation  
- User dashboard displaying account information and balance  
- Transaction form for transferring funds  
- Auth Guard and HTTP Interceptor for token management  

---

## Docker Setup

```bash
# Build the project
docker compose build

# Start all services
docker compose up
```

Default ports:
- API Gateway: **8080**  
- Account Service: **9090**  
- Transaction Service: **9091**  
- PostgreSQL: **5433**  
- Angular Frontend: **4200**

---

## Example API Requests

### Login
```bash
POST http://localhost:8080/api/v1/auth/login
{
  "email": "user@example.com",
  "password": "password123"
}
```

### Fund Transfer
```bash
POST http://localhost:8080/api/v1/transactions/transfer
{
  "from_account_id": "1111",
  "to_account_id": "2222",
  "amount": 100.0
}
```

---

## Testing and Quality Assurance

- Unit tests implemented with **JUnit** and **Mockito**  
- Integration testing using **Testcontainers**  
- Emphasis on reliability, scalability, and clean modular design  

---

## Deployment

Each service can be built and deployed independently or orchestrated via Docker Compose:

```bash
docker compose up -d account-service transaction-service api-gateway
```

---

## Author

**Umut Avcı**  
Full-Stack Developer  
[LinkedIn](#) • [GitHub](#)
