package com.example.articlesapi.repository;

import com.example.articlesapi.entity.Article;
import com.example.articlesapi.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyWordRepository extends JpaRepository<KeyWord, Integer> {
    List<KeyWord> findByArticle(Article article);
}
