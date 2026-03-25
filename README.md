# Person Address API

## 📌 Description
REST API desenvolvida em **Java 21 + Spring Boot** para gerenciar pessoas e seus endereços.  
Permite criar, listar, buscar, atualizar e deletar pessoas, além de cadastrar múltiplos endereços para cada pessoa.  
Projeto acadêmico com foco em boas práticas de backend.

---

## 🚀 Technologies
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL / H2 (para testes)
- Maven
- Swagger / OpenAPI
- Bean Validation
- Global Exception Handler

---

## 📂 Project Architecture
Camadas: **Controller → Service → Repository → Database**

### Packages
- `controller` → endpoints da API
- `service` → regras de negócio
- `repository` → acesso ao banco
- `database.model` → entidades JPA
- `dto` → objetos de transferência (PersonDto, AddressDto)
- `mapper` → conversão Entity ↔ DTO
- `exception` → exceções customizadas
- `handler` → tratamento global de erros
- `utils` → resposta de erro padronizada

---

## 📌 Features
- CRUD de pessoas
- CRUD de endereços aninhados
- Regra de negócio: apenas **1 endereço principal por pessoa**
- Validações com Bean Validation
- Exceções customizadas (`NotFoundException`, `BusinessException`)
- Tratamento de CPF duplicado (`409 Conflict`)
- Swagger para documentação

---

## 📌 Endpoints

### Pessoas
- `POST /pessoas` → Criar pessoa
- `GET /pessoas` → Listar todas
- `GET /pessoas/{id}` → Buscar por ID
- `PUT /pessoas/{id}` → Atualizar pessoa
- `DELETE /pessoas/{id}` → Deletar pessoa

### Endereços (rotas aninhadas)
- `POST /pessoas/{id}/enderecos` → Criar endereço para pessoa
- `PUT /pessoas/{id}/enderecos/{enderecoId}` → Atualizar endereço
- `DELETE /pessoas/{id}/enderecos/{enderecoId}` → Deletar endereço

---

## 📌 Example Request/Response

### Criar pessoa

**Request**
```json
POST /pessoas
{
  "name": "Maria Silva",
  "cpf": "12345678900",
  "email": "maria@email.com",
  "birthDate": "1990-05-10",
  "phones": ["11999999999"]
}
```

**Response**
```json
{
  "id": 1,
  "name": "Maria Silva",
  "cpf": "12345678900",
  "email": "maria@email.com",
  "birthDate": "1990-05-10",
  "phones": ["11999999999"],
  "addresses": []
}
```

---

### Criar endereço

**Request**
```json
POST /pessoas/1/enderecos
{
  "street": "Rua das Flores",
  "number": 100,
  "neighborhood": "Centro",
  "city": "São Paulo",
  "state": "SP",
  "zipCode": "01000-000",
  "primaryAddress": true
}
```

**Response**
```json
{
  "id": 1,
  "street": "Rua das Flores",
  "number": 100,
  "neighborhood": "Centro",
  "city": "São Paulo",
  "state": "SP",
  "zipCode": "01000-000",
  "primaryAddress": true
}
```

---

## 📌 Validation

- `@NotBlank` → campos obrigatórios
- `@NotNull` → valores não nulos
- `@Valid` → validação em cascata

Erros são tratados pelo **GlobalExceptionHandler** e retornam JSON padronizado.

---

## 📌 Exception Handling

Exceções customizadas:
- NotFoundException
- BusinessException

Tratamento global:
- GlobalExceptionHandler

Exemplo de erro:

```json
{
  "status": 409,
  "error": "Conflict",
  "message": "CPF já existe no sistema",
  "path": "/pessoas"
}
```

---

## 📌 Database

Relacionamento:

Person 1 → N Address

Tabelas:
- person
- address
- person_phone

JPA / Hibernate usados para ORM.

---

## 📌 Swagger

Swagger UI disponível em:

```
http://localhost:8080/swagger-ui.html
```

ou

```
http://localhost:8080/swagger-ui/index.html
```

---

## ▶ How to run

Configure o banco em `application.yaml` (MySQL ou H2).

Execute com:

```
mvn spring-boot:run
```

ou pelo IntelliJ.

Acesse o Swagger para testar os endpoints.

---

## 📌 Exemplo de configuração application.yaml

### MySQL

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/pessoa_endereco
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

### H2 (memória)

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:

  h2:
    console:
      enabled: true

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 👨‍💻 Author

Rogerio Rissutti Liuzzi Junior  
Computer Science Student  
Backend Developer