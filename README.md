# 📡 Real-Time Chat API (Spring Boot + WebSocket + JWT)

API de chat em tempo real com autenticação JWT, salas privadas e comunicação via WebSocket, construída com Spring Boot.

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring WebSocket (STOMP + SockJS)
- Spring Security + JWT
- Spring Data JPA + H2
- Maven

---

## 📁 Estrutura do Projeto

```
chat-api/
├── src/main/java/com/chat/
│   ├── Application.java
│   ├── config/WebSocketConfig.java
│   ├── controller/
│   │   ├── AuthController.java
│   │   ├── ChatController.java
│   │   └── RoomController.java
│   ├── model/
│   │   ├── ChatMessage.java
│   │   ├── Room.java
│   │   └── User.java
│   ├── repository/
│   │   ├── RoomRepository.java
│   │   └── UserRepository.java
│   └── security/
│       ├── JwtUtil.java
│       └── SecurityConfig.java
├── resources/
│   └── application.properties
└── pom.xml
```

---

## 🔐 Autenticação JWT

### 📌 Rotas públicas:

- `POST /api/auth/register` – cria um novo usuário
- `POST /api/auth/login` – retorna um token JWT

### 🔐 Rotas protegidas (necessário `Authorization: Bearer <token>`):

- `POST /api/rooms` – cria uma nova sala com usuários
- `GET /api/rooms/{code}` – busca sala por código
- WebSocket em `/ws` também requer JWT no header (se configurado)

---

## 🧪 Testando com Postman

### 1. Registrar:
```
POST /api/auth/register
{
  "username": "joao",
  "password": "senha123"
}
```

### 2. Login:
```
POST /api/auth/login
{
  "username": "joao",
  "password": "senha123"
}
```

### 3. Criar sala:
```
POST /api/rooms
Headers: Authorization: Bearer <TOKEN>
Body: ["joao", "maria"]
```

---

## 📡 WebSocket

- Endpoint STOMP: `/ws`
- Enviar para: `/app/chat/{roomId}`
- Receber de: `/topic/room/{roomId}`

---

## 🧰 Requisitos

- JDK 17+
- Maven

---

## ▶️ Rodando localmente

```bash
git clone https://github.com/seu-usuario/chat-api.git
cd chat-api
mvn spring-boot:run
```

---

## 🧪 Banco de dados H2

Console disponível em:  
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Senha: *(em branco)*

---

## 📌 To-Do

- [x] Autenticação JWT
- [x] Chat em tempo real via WebSocket
- [x] Salas privadas entre dois usuário

---

