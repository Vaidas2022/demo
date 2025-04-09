# eDemocracy – Civic Participation Platform 🇱🇹

A Spring Boot-based backend for a digital civic participation platform.  
The goal is to provide Lithuanian citizens with a modern, secure, and transparent way to engage in democratic processes.

---

## 🚀 Features

- ✅ User registration and login (username + password)
- ✅ JWT token-based authentication
- ✅ In-memory user storage (for development/demo)
- 🛡️ BCrypt password hashing
- 🔐 Secure REST endpoints with Spring Security
- ⚙️ Ready for future modules: petitions, political promises, AI-powered news analysis

---

## 📦 Tech Stack

- **Java 21**  
- **Spring Boot 3.4.4**  
- **Spring Security 6**  
- **JWT (via jjwt)**  
- **BCryptPasswordEncoder**  
- **Maven**

---

## 🧪 Endpoints

### Authentication
| Method | Endpoint           | Description            |
|--------|--------------------|------------------------|
| POST   | `/api/auth/register` | Register new user      |
| POST   | `/api/auth/login`    | Login, get JWT token   |
| GET    | `/api/auth/me`       | (Planned) Get current user info |

---

## 🛠 Setup & Run

```bash
git clone https://github.com/Vaidas2022/demo.git
cd demo
./mvnw spring-boot:run
