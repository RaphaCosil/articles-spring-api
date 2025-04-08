package com.example.articlesapi.repository;

import com.example.articlesapi.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyWordRepository extends JpaRepository<KeyWord, Integer> {
}
