# Articles API

A RESTful API construída em **Java 21** usando **Spring Boot**, responsável por gerenciar:

- Usuários (`User`)
- Artigos (`Article`)
- Palavras-chave (`Keyword`)

## Estrutura do Projeto

```bash
.
├── src/main/java/com/example/articlesapi/
│   ├── config/                   # Configurações de aplicação
│   ├── contract/                 # Interfaces dos endpoints (controllers)
│   ├── controller/               # Controllers que implementam os contracts
│   ├── dto/                      # Data Transfer Objects
│   ├── exception/                # Manipulação de exceções
│   ├── model/                    # Entidades JPA
│   ├── repository/               # Interfaces de acesso a dados (Spring Data JPA)
│   └── service/                  # Regras de negócio
└── src/main/resources/
└── application.properties    # Configurações de banco e aplicação
```

## Rotas da API

### **`/user`**

| Método | Rota               | Descrição             |
|:---------|:--------------------|:----------------------|
| GET     | `/user/`              | Listar todos os usuários |
| GET     | `/user/{id}`          | Buscar usuário por ID    |
| POST    | `/user/`              | Criar novo usuário        |
| PUT     | `/user/{id}`          | Atualizar usuário         |
| DELETE  | `/user/{id}`          | Remover usuário           |

### **`/articles`**

| Método | Rota                                      | Descrição                                     |
|:---------|:--------------------------------------------|:------------------------------------------------|
| GET     | `/articles/`                               | Listar todos os artigos                         |
| GET     | `/articles/{id}`                           | Buscar artigo por ID                            |
| POST    | `/articles/`                               | Criar novo artigo                                |
| PUT     | `/articles/{id}`                           | Atualizar artigo                                 |
| DELETE  | `/articles/{id}`                           | Remover artigo                                   |
| GET     | `/articles/title/{title}`                  | Buscar artigos contendo o título                |
| GET     | `/articles/content/{content}`              | Buscar artigos contendo o conteúdo              |
| GET     | `/articles/keywords/{keywords}`            | Buscar artigos contendo qualquer keyword        |
| GET     | `/articles/keywords-filter/{keywords}`     | Buscar artigos contendo todas as keywords       |

### **`/keywords`**

| Método | Rota                            | Descrição                                |
|:---------|:--------------------------------|:--------------------------------------------|
| GET     | `/keywords/`                    | Listar todas as keywords                   |
| GET     | `/keywords/{id}`                | Buscar keyword por ID                      |
| POST    | `/keywords/`                    | Criar nova keyword                         |
| DELETE  | `/keywords/{id}`                | Remover keyword                            |
| GET     | `/keywords/article/{articleId}` | Listar keywords associadas a um artigo     |

## Setup

1. Configure o banco e as variáveis no `application.properties`
2. Crie o schema no banco (`articles_db`)
3. Execute o projeto:

```bash
./mvnw spring-boot:run
```

1. Acesse a documentação Swagger:

```
http://localhost:8080/swagger-ui/index.html
```
