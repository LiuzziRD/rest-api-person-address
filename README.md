# 📘 Projeto API Pessoa-Endereço

API REST desenvolvida em Java 21 + Spring Boot para gerenciar pessoas e seus endereços.
A aplicação utiliza MySQL como banco de dados e possui documentação automática com Swagger (Springdoc OpenAPI).

O projeto foi desenvolvido para fins acadêmicos, com foco em boas práticas de backend, organização em camadas e tratamento de exceções.

--------------------------------------------------

## 🚀 Pré-requisitos

Antes de executar o projeto, instale:

- Java 21
- MySQL Server
- Git
- IntelliJ IDEA (recomendado)
- Maven Wrapper (já incluído no projeto)

Não é necessário instalar Maven globalmente.

--------------------------------------------------

## 🛠️ Configuração do Banco de Dados

Crie o banco no MySQL:

CREATE DATABASE db_projectapi;

Copie o arquivo de exemplo para criar sua configuração real:

cp src/main/resources/application-example.yaml src/main/resources/application.yaml

Edite o arquivo:

src/main/resources/application.yaml

Configure usuário e senha:

spring:
datasource:
url: jdbc:mysql://localhost:3306/db_projectapi
username: root
password: sua_senha

--------------------------------------------------

## ▶️ Como rodar o projeto

Linux / Mac

./mvnw spring-boot:run

Windows (PowerShell)

.\mvnw.cmd spring-boot:run

Se tudo estiver correto, a API irá subir em:

http://localhost:8080

--------------------------------------------------

## 📑 Documentação da API (Swagger)

Após iniciar o projeto, acesse:

http://localhost:8080/swagger-ui/index.html

Lá estarão todos os endpoints disponíveis.

--------------------------------------------------

## 📌 Endpoints principais

Pessoas

POST /pessoas → Criar pessoa  
GET /pessoas/{id} → Buscar por ID  
PUT /pessoas/{id} → Atualizar  
DELETE /pessoas/{id} → Remover

Endereços

POST /pessoas/{id}/enderecos → Adicionar endereço  
PUT /pessoas/{id}/enderecos/{enderecoId} → Atualizar endereço  
DELETE /pessoas/{id}/enderecos/{enderecoId} → Remover endereço

Regras de negócio:

- Uma pessoa pode ter vários endereços
- Apenas um endereço pode ser principal

--------------------------------------------------

## ⚠️ Tratamento de erros

A API retorna erros padronizados em JSON.

Erro de validação

{
"status": 400,
"error": "Validation Error",
"message": "{cpf=CPF é obrigatório}",
"path": "/pessoas"
}

Recurso não encontrado

{
"status": 404,
"error": "Not Found",
"message": "Pessoa não encontrada",
"path": "/pessoas/99"
}

--------------------------------------------------

## 📂 Estrutura do Projeto

src/
├── main/java/br/com/rogerio/api/pessoaendereco
│    ├── controller   → Controllers REST
│    ├── service      → Regras de negócio
│    ├── database
│    │     ├── model
│    │     └── repository
│    ├── dto          → DTOs com validação
│    ├── exception    → Exceções customizadas
│    ├── handler      → GlobalExceptionHandler
│    └── utils        → Classes auxiliares
│
└── main/resources
├── application.yaml
└── application-example.yaml

--------------------------------------------------

## ✅ Funcionalidades implementadas

- CRUD de pessoas
- CRUD de endereços
- Relacionamento Pessoa → Endereços
- Validação com @Valid
- Tratamento global de exceções
- Respostas JSON padronizadas
- Documentação com Swagger
- Configuração externa com YAML
- Maven Wrapper

--------------------------------------------------

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido para estudo de:

- Spring Boot
- API REST
- JPA / Hibernate
- Bean Validation
- Tratamento de erros
- Arquitetura em camadas
- Boas práticas de backend