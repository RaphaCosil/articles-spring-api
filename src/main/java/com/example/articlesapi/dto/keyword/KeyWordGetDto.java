package com.example.articlesapi.dto.keyword;

public record KeyWordGetDto (
    int keyWordId,
    int articleId,
    String content,
    String createdAt,
    String updatedAt
) {
}
