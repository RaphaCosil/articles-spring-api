package com.example.articlesapi.dto.article;

import com.example.articlesapi.entity.User;

public record ArticleGetDto(
    int articleId,
    User sender,
    String title,
    String content,
    String createdAt,
    String updatedAt
) {
}
