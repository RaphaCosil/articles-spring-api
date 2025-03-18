package com.example.articlesapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class UserGetDto {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private String studyArea;
    private Date createdAt;
    private Date updatedAt;
}
