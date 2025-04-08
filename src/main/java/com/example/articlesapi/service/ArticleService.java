package com.example.articlesapi.service;

import com.example.articlesapi.repository.ArticleRepository;

public class ArticleService {
     ArticleRepository articleRepository;

     public ArticleService(ArticleRepository articleRepository) {
         this.articleRepository = articleRepository;
     }

     

}
