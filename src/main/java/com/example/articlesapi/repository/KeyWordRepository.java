package com.example.articlesapi.repository;

import com.example.articlesapi.entity.Article;
import com.example.articlesapi.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeyWordRepository extends JpaRepository<KeyWord, Integer> {
    List<KeyWord> findByArticle(Article article);
}
