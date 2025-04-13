package com.example.articlesapi.controller;

import com.example.articlesapi.contract.ArticleContract;
import com.example.articlesapi.dto.article.ArticleGetDto;
import com.example.articlesapi.dto.article.ArticlePostDto;
import com.example.articlesapi.dto.article.ArticleUpdateDto;
import com.example.articlesapi.exception.BadRequestException;
import com.example.articlesapi.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public class ArticleController implements ArticleContract {
    ArticleService articleService;
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<Void> save(ArticlePostDto articlePostDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(
                    bindingResult.getFieldError().getDefaultMessage()
            );
        }
        articleService.save(articlePostDto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<List<ArticleGetDto>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @Override
    public ResponseEntity<ArticleGetDto> findById(int id) {
        return ResponseEntity.ok(articleService.findById(id));
    }

    @Override
    public ResponseEntity<Void> update(int id, ArticleUpdateDto articleUpdateDto) {
        articleService.update(id, articleUpdateDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        articleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ArticleGetDto>> findByTitleContaining(String title) {
        return ResponseEntity.ok(articleService.findByTitleContaining(title));
    }

    @Override
    public ResponseEntity<List<ArticleGetDto>> findByContentContaining(String content) {
        return ResponseEntity.ok(articleService.findByContentContaining(content));
    }

    @Override
    public ResponseEntity<List<ArticleGetDto>> findByKeywords(List<String> keywords) {
        return ResponseEntity.ok(articleService.findByKeywords(keywords));
    }

    @Override
    public ResponseEntity<List<ArticleGetDto>> findByKeywordsFilter(List<String> keywords) {
        return ResponseEntity.ok(articleService.findByKeywordsFilter(keywords));
    }
}
