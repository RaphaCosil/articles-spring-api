package com.example.articlesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "API Example", version = "1.0.0")
)
@SpringBootApplication
public class ArticlesApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticlesApiApplication.class, args);
    }
}

