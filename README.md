## 🚀 PROJETO FINAL — API RESTful com Spring Boot

# 🎬 SerratecFlix

---

## 🎯 Objetivo

Desenvolver uma API RESTful completa, aplicando os conceitos estudados durante o curso.
O projeto deverá seguir boas práticas de desenvolvimento backend, arquitetura em camadas, persistência de dados, autenticação, documentação e organização profissional do código.

---

## 📖 Tema Escolhido

O **SerratecFlix** é uma plataforma de streaming geek onde usuários podem avaliar filmes, séries e animes, criar listas, favoritar conteúdos e acompanhar sua watchlist.

---

## 👥 Integrantes / 📋 Responsabilidades

🧑‍💻 **Bruno Vitor** — Entidades Filme, Categoria e AvaliaçãoFilme com seus respectivos pacotes. Métodos adicionais de Ranking/filmes e listagem de filmes por categoria. Criação do README.

🧑‍💻 **Igor Bryan** — Entidades Usuario e ListaFavoritos com seus respectivos pacotes. Implementação da API externa ViaCep e histórico de filmes/séries assistidas do usuário.

🧑‍💻 **Kenny Robert** — Implementação do pacote exception e filtro de conteúdo nas avaliações do usuário.

🧑‍💻 **Wallace Ildefonso** — Entidades Série e AvaliacaoSerie com seus respectivos pacotes. Métodos adicionais de lista de avaliações na série, camada de segurança e desenvolvimento de uma página HTML para Séries.

---

## 🛠️ Tecnologias

### Back-end

☕ **Java** — Linguagem principal do projeto

🌱 **Spring Boot** — Framework para construção da API REST

🗄️ **Spring Data JPA** — Abstração de acesso a dados com repositórios

🔄 **Hibernate** — ORM para mapeamento objeto-relacional

🐘 **PostgreSQL** — Banco de dados relacional

📦 **Maven** — Gerenciador de dependências e build

📄 **Swagger / OpenAPI** — Documentação interativa da API

🔐 **Spring Security** — Controle de autenticação e autorização

🪙 **JWT** — Tokens de autenticação stateless

✅ **Bean Validation** — Validação de dados nas requisições

### Versionamento

🐙 **Git / GitHub** — Controle de versão e colaboração em equipe

---

## 🚀 Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/serratecflix.git
cd serratecflix

# Configure o banco em application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/serratecflix
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute
mvn spring-boot:run
```

Acesse a documentação: `http://localhost:8080/swagger-ui.html`

---

## 🔗 Endpoints Principais

**🔐 Auth**

`POST /auth/login` — Cadastrar usuário

**🎬 Filmes**

`GET /filmes` — Lista todos os filmes

`POST /filmes` — Cadastra filme

`DELETE /filmes/{id}` — Remove filme

`GET /filmes/categoria/{id}` — Lista por categoria

`GET /filmes/ranking` — Lista um ranking de filmes de acordo com a notaMedia por usuário

`GET /avaliacoes-filme` — Lista avaliações de filmes

`POST /avaliacoes-filme` — Cadastra avaliação de filme

**📺 Séries**

`GET /series` — Lista todas as séries

`POST /series` — Cadastra série

`DELETE /series/{id}` — Remove série

`GET /avaliacao-serie` — Lista avaliações de séries

`POST /avaliacao-serie` — Cadastra avaliação de série

**🗂️ Categorias**

`GET /categorias` — Lista todas as categorias

`POST /categorias` — Cadastra categoria

`DELETE /categorias/{id}` — Remove categoria

**👤 Usuários**

`GET /usuarios` — Lista todos os usuários

`GET /usuarios/{id}` — Busca por ID

`PUT /usuarios/{id}` — Atualiza usuário

`DELETE /usuarios/{id}` — Remove usuário

---

## 📌 Observações

- Tabelas criadas automaticamente via Hibernate (`ddl-auto=update`)
- Endpoints documentados e testáveis via Swagger

---
