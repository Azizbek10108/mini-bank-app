# 🏦 Mini Bank API

> A secure REST API for banking operations built with Java Spring Boot.
> Java Spring Boot yordamida yaratilgan xavfsiz bank REST API.

---

## 📋 Loyiha tavsifi | Project Description

**O'zbekcha:**
Bu loyiha foydalanuvchilarga bank hisobini ochish, pul qo'yish, yechish va o'tkazish imkonini beruvchi REST API hisoblanadi. Har bir operatsiya PIN kod orqali himoyalangan.

**English:**
This project is a REST API that allows users to create bank accounts, deposit, withdraw, and transfer money. Every operation is secured with a PIN code.

---

## 🛠 Texnologiyalar | Technologies

| Texnologiya | Versiya |
|-------------|---------|
| Java | 17+ |
| Spring Boot | 3.x |
| Spring Data JPA | 3.x |
| PostgreSQL | 14+ |
| Lombok | 1.18+ |
| Maven | 3.x |

---

## 🚀 API Endpointlar | API Endpoints

### Account

| Method | URL | Tavsif | Description |
|--------|-----|--------|-------------|
| `POST` | `/api/accounts` | Yangi hisob ochish | Create account |
| `GET` | `/api/accounts/{id}` | Hisob ma'lumotlari | Get account |
| `PUT` | `/api/accounts/{id}/deposit` | Pul qo'yish | Deposit money |
| `PUT` | `/api/accounts/{id}/withdraw` | Pul yechish | Withdraw money |
| `POST` | `/api/accounts/transfer` | Pul o'tkazish | Transfer money |

### Misol | Example

**Hisob yaratish | Create Account:**
```json
POST /api/accounts
{
  "fullname": "Azizbek Karimov",
  "pinCode": "1234",
  "phone": "+998901234567"
}
```

**Pul o'tkazish | Transfer:**
```
POST /api/accounts/transfer
?fromId=1&toId=2&amount=5000&pinCode=1234
```

---

## ⚙️ O'rnatish | Installation

```bash
# 1. Reponi clone qiling | Clone the repo
git clone https://github.com/username/bank-api.git

# 2. PostgreSQL da database yarating | Create database
CREATE DATABASE bankdb;

# 3. application.properties ni sozlang | Configure
spring.datasource.url=jdbc:postgresql://localhost:5432/bankdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# 4. Ishga tushiring | Run
mvn spring-boot:run
```

---

## 👨‍💻 Muallif | Author

**Anvarov Azizbek**
- 17 yoshli Java dasturchisi | 17-year-old Java Developer
- GitHub: [@username](https://github.com/username)

---

⭐ Agar loyiha yoqsa, yulduzcha qoldiring! | Star the repo if you like it!