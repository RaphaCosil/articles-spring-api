package com.example.articlesapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @NotNull(message = "User name is required")
    @Size(min = 3, max = 255, message = "User name must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "User email is required")
    @Size(min = 3, max = 255, message = "User email must be between 3 and 255 characters")
    private String email;

    @NotNull(message = "User password is required")
    @Size(min = 3, max = 255, message = "User password must be between 3 and 255 characters")
    private String password;

    @NotNull(message = "User role is required")
    @Size(min = 3, max = 255, message = "User role must be between 3 and 255 characters")
    private String role;

    @NotNull(message = "User study area is required")
    @Size(min = 3, max = 255, message = "User study area must be between 3 and 255 characters")
    @Column(name = "study_area")
    private String studyArea;

    @NotNull(message = "Created at is required")
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
