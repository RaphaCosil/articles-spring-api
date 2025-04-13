package com.example.articlesapi.service;

import com.example.articlesapi.dto.article.ArticleGetDto;
import com.example.articlesapi.dto.article.ArticlePostDto;
import com.example.articlesapi.dto.article.ArticleUpdateDto;
import com.example.articlesapi.entity.Article;
import com.example.articlesapi.entity.User;
import com.example.articlesapi.exception.NotFoundException;
import com.example.articlesapi.repository.ArticleRepository;
import com.example.articlesapi.repository.UserRepository;

import java.util.Optional;

public class ArticleService {
    UserRepository userRepository;
    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<ArticleGetDto> findAll() {
        return articleRepository.findAll().stream().map(this::parseArticleGetDtoToArticle).toList();
    }

    public ArticleGetDto findById(int id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return parseArticleGetDtoToArticle(article.get());
        } else {
            throw new NotFoundException();
        }
    }

    public void save(ArticlePostDto articlePostDto) {
        articleRepository.save(
                parseArticleToArticlePostDto(articlePostDto)
        );
    }

    public void update(int id, ArticleUpdateDto articleUpdateDto) {
        Article existingArticle = articleRepository.findById(id).orElse(null);
        if (existingArticle != null) {
            existingArticle = parseArticleToArticleUpdateDto(articleUpdateDto);
            articleRepository.save(existingArticle);
        } else {
            throw new NotFoundException();
        }
    }

    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }

    private ArticleGetDto parseArticleGetDtoToArticle(Article article) {
        return new ArticleGetDto(
                article.getArticleId(),
                article.getSender(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt(),
                article.getUpdatedAt()
        );
    }

    private Article parseArticleToArticlePostDto(ArticlePostDto articlePostDto) {
        User user = userRepository.findById(articlePostDto.senderId()).orElse(null);
        if (user == null) {
            throw new NotFoundException();
        }
        Article article = new Article();
        article.setSender(user);
        article.setTitle(articlePostDto.title());
        article.setContent(articlePostDto.content());
        return article;
    }

    private Article parseArticleToArticleUpdateDto(ArticleUpdateDto articleUpdateDto) {
        Article article = new Article();
        article.setTitle(articleUpdateDto.title());
        article.setContent(articleUpdateDto.content());
        article.setUpdatedAt(articleUpdateDto.updatedAt());
        return article;
    }
}
