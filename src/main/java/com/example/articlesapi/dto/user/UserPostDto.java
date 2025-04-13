package com.example.articlesapi.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserPostDto (
    @NotNull(message = "User name is required")
    @Size(min = 3, max = 255, message = "User name must be between 3 and 255 characters")
    String name,
    @NotNull(message = "User email is required")
    @Size(min = 3, max = 255, message = "User email must be between 3 and 255 characters")
    String email,
    @NotNull(message = "User password is required")
    @Size(min = 3, max = 255, message = "User password must be between 3 and 255 characters")
    String password,
    @NotNull(message = "User role is required")
    @Size(min = 3, max = 255, message = "User role must be between 3 and 255 characters")
    String role,
    @NotNull(message = "User study area is required")
    @Size(min = 3, max = 255, message = "User study area must be between 3 and 255 characters")
    String studyArea
) {
}
