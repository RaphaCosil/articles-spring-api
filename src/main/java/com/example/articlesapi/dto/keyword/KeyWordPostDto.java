package com.example.articlesapi.dto.keyword;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record KeyWordPostDto (
    @NotNull(message = "Article ID is required")
    int articleId,
    @NotNull(message = "Content is required")
    @Size(min = 3, max = 255, message = "Content must be between 3 and 255 characters")
    String content
) {
}
