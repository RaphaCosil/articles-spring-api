package com.example.articlesapi.dto.user;

import java.sql.Date;

public record UserUpdateDto (
    String name,
    String email,
    String password,
    String role,
    String studyArea,
    Date createdAt
){
}
