package com.example.articlesapi.dto.article;

public record ArticleUpdateDto (
    String title,
    String content,
    String updatedAt
){
}
