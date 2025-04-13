package com.example.articlesapi.dto.article;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticlePostDto(
    @NotNull(message = "Sender ID is required")
    int senderId,
    @NotNull(message = "Title is required")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    String title,
    @NotNull(message = "Content is required")
    String content
) {
}
