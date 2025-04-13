# Articles API

A RESTful API built in **Java** using **Spring Boot**, responsible for managing:

- Users (`User`)
- Articles (`Article`)
- Keywords (`Keyword`)

## Project Structure

```bash
.
├── src/main/java/com/example/articlesapi/
│   ├── config/                   # Application configuration
│   ├── contract/                 # API endpoint interfaces (contracts)
│   ├── controller/               # Controllers implementing the contracts
│   ├── dto/                      # Data Transfer Objects
│   ├── exception/                # Exception handling
│   ├── model/                    # JPA Entities
│   ├── repository/               # Data access interfaces (Spring Data JPA)
│   └── service/                  # Business logic
└── src/main/resources/
└── application.properties        # Application and database configuration
```

## API Routes

### **`/user`**

| Method | Route        | Description           |
|:--------|:---------------|:----------------------|
| GET    | `/user/`        | List all users          |
| GET    | `/user/{id}`    | Get user by ID          |
| POST   | `/user/`        | Create new user         |
| PUT    | `/user/{id}`    | Update user             |
| DELETE | `/user/{id}`    | Delete user             |

### **`/articles`**

| Method | Route                                  | Description                                  |
|:--------|:------------------------------------------|:-----------------------------------------------|
| GET    | `/articles/`                             | List all articles                             |
| GET    | `/articles/{id}`                         | Get article by ID                             |
| POST   | `/articles/`                             | Create new article                            |
| PUT    | `/articles/{id}`                         | Update article                                |
| DELETE | `/articles/{id}`                         | Delete article                                |
| GET    | `/articles/title/{title}`                | Find articles containing title                |
| GET    | `/articles/content/{content}`            | Find articles containing content              |
| GET    | `/articles/keywords/{keywords}`          | Find articles containing any keyword          |
| GET    | `/articles/keywords-filter/{keywords}`   | Find articles containing all specified keywords |

### **`/keywords`**

| Method | Route                               | Description                              |
|:--------|:--------------------------------------|:---------------------------------------------|
| GET    | `/keywords/`                         | List all keywords                          |
| GET    | `/keywords/{id}`                     | Get keyword by ID                          |
| POST   | `/keywords/`                         | Create new keyword                         |
| DELETE | `/keywords/{id}`                     | Delete keyword                             |
| GET    | `/keywords/article/{articleId}`      | List keywords associated with an article   |

## Setup

1. Configure the database and environment variables in `application.properties`
2. Create the database schema (`db`)
3. Run the project:

```bash
./mvnw spring-boot:run
```

4. Access Swagger documentation:

```
http://localhost:8080/swagger-ui/index.html
```
