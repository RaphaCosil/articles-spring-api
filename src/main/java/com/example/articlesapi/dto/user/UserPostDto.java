package com.example.articlesapi.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class UserPostDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private String studyArea;
    private Date createdAt;
}
