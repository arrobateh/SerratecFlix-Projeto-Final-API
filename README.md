<div align="center">

### 🚀 PROJETO FINAL
#### API RESTful com Spring Boot

# 🎬 SerratecFlix


</div>

---

## 👥 Integrantes

| 👤 Nome | 📋 Responsabilidades |
|---|---|
| 🧑‍💻 Bruno Vitor | Entidades Filme, Categoria e AvaliaçãoFilme com seus respectivos pacotes. Métodos adicionais de Ranking/filmes e listagem de filmes por categoria. Criação do README. |
| 🧑‍💻 Igor Bryan | Entidades Usuario e ListaFavoritos com seus respectivos pacotes. Implementação da API externa ViaCep e histórico de filmes/séries assistidas do usuário. |
| 🧑‍💻 Kenny Robert | Implementação do pacote exception e filtro de conteúdo nas avaliações do usuário. |
| 🧑‍💻 Wallace Ildefonso | Entidades Série e AvaliacaoSerie com seus respectivos pacotes. Métodos adicionais de lista de avaliações na série, camada de segurança e desenvolvimento de uma página HTML para Séries. |

---

## 📖 Descrição

O **SerratecFlix** é uma plataforma de streaming geek onde usuários podem avaliar filmes, séries e animes, criar listas, favoritar conteúdos e acompanhar sua watchlist.

---

## 🛠️ Tecnologias

### Back-end
| Tecnologia | Descrição |
|---|---|
| ☕ **Java** | Linguagem principal do projeto |
| 🌱 **Spring Boot** | Framework para construção da API REST |
| 🗄️ **Spring Data JPA** | Abstração de acesso a dados com repositórios |
| 🔄 **Hibernate** | ORM para mapeamento objeto-relacional |
| 🐘 **PostgreSQL** | Banco de dados relacional |
| 📦 **Maven** | Gerenciador de dependências e build |
| 📄 **Swagger / OpenAPI** | Documentação interativa da API |
| 🔐 **Spring Security** | Controle de autenticação e autorização |
| 🪙 **JWT** | Tokens de autenticação stateless |
| ✅ **Bean Validation** | Validação de dados nas requisições |

### Versionamento
| Tecnologia | Descrição |
|---|---|
| 🐙 **Git / GitHub** | Controle de versão e colaboração em equipe |

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

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/auth/register` | Cadastro de usuário |
| `POST` | `/auth/login` | Login / geração de token |
| `GET` | `/filmes` | Lista todos os filmes |
| `POST` | `/filmes` | Cadastra um novo filme |
| `GET` | `/filmes/{id}` | Busca filme por ID |
| `PUT` | `/filmes/{id}` | Atualiza um filme |
| `DELETE` | `/filmes/{id}` | Remove um filme |
| `GET` | `/filmes/categoria/{id}` | Lista filmes por categoria |
| `GET` | `/series` | Lista todas as séries |
| `POST` | `/series` | Cadastra uma nova série |
| `GET` | `/series/{id}` | Busca série por ID |
| `PUT` | `/series/{id}` | Atualiza uma série |
| `DELETE` | `/series/{id}` | Remove uma série |
| `GET` | `/categorias` | Lista todas as categorias |
| `POST` | `/categorias` | Cadastra uma nova categoria |
| `DELETE` | `/categorias/{id}` | Remove uma categoria |

> 🔑 Todos os endpoints (exceto `/auth/*`) exigem token JWT no header: `Authorization: Bearer {token}`

---

## 📌 Observações

- Perfis de acesso: `USER` e `ADMIN`
- Tabelas criadas automaticamente via Hibernate (`ddl-auto=update`)
- Endpoints documentados e testáveis via Swagger

---
