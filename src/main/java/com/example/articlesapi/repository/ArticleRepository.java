package com.example.articlesapi.repository;

import com.example.articlesapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("SELECT a FROM Article a WHERE a.title LIKE %:title%")
    List<Article> findByTitleContaining(String title);

    @Query("SELECT a FROM Article a WHERE a.content LIKE %:content%")
    List<Article> findByContentContaining(String content);

    @Query("SELECT a FROM Article a WHERE a.articleId IN (" +
            "SELECT k.article FROM KeyWord k WHERE k.content IN :keywords)")
    List<Article> findByKeywords(@Param("keywords") List<String> keywords);

    @Query("SELECT a FROM Article a WHERE a.articleId IN (" +
            "SELECT k.article.articleId FROM KeyWord k WHERE k.content IN :keywords " +
            "GROUP BY k.article.articleId " +
            "HAVING COUNT(DISTINCT k.content) = :keywordCount)")
    List<Article> findByKeywordsFilter(
            @Param("keywords") List<String> keywords,
            @Param("keywordCount") long keywordCount
    );
}
