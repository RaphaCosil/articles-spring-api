package com.example.articlesapi.service;

import com.example.articlesapi.dto.article.ArticleGetDto;
import com.example.articlesapi.dto.article.ArticlePostDto;
import com.example.articlesapi.dto.article.ArticleUpdateDto;
import com.example.articlesapi.entity.Article;
import com.example.articlesapi.entity.User;
import com.example.articlesapi.exception.NotFoundException;
import com.example.articlesapi.repository.ArticleRepository;
import com.example.articlesapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    UserRepository userRepository;
    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void save(ArticlePostDto articlePostDto) {
        articleRepository.save(
                parseArticleToArticlePostDto(articlePostDto)
        );
    }

    public void update(int id, ArticleUpdateDto articleUpdateDto) {
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        articleRepository.save(
                parseArticleToArticleUpdateDto(
                        existingArticle,
                        articleUpdateDto
                )
        );
    }

    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }

    public List<ArticleGetDto> findAll() {
        return parseArticlesGetDtoToArticles(
                articleRepository.findAll()
        );
    }

    public ArticleGetDto findById(int id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return parseArticleGetDtoToArticle(article.get());
        } else {
            throw new NotFoundException();
        }
    }

    public List<ArticleGetDto> findByTitleContaining(String title) {
        return parseArticlesGetDtoToArticles(
                articleRepository.findByTitleContaining(title)
        );
    }

    public List<ArticleGetDto> findByContentContaining(String content) {
        return parseArticlesGetDtoToArticles(
                articleRepository.findByContentContaining(content)
        );
    }

    public List<ArticleGetDto> findByKeywords(List<String> keywords) {
        return parseArticlesGetDtoToArticles(
                articleRepository.findByKeywords(keywords)
        );
    }

    public List<ArticleGetDto> findByKeywordsFilter(List<String> keywords) {
        return parseArticlesGetDtoToArticles(
                articleRepository.findByKeywordsFilter(keywords, keywords.size())
        );
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

    private List<ArticleGetDto> parseArticlesGetDtoToArticles(List<Article> articles) {
        return articles.stream().map(this::parseArticleGetDtoToArticle).toList();
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

    private Article parseArticleToArticleUpdateDto(Article article, ArticleUpdateDto articleUpdateDto) {
        article.setTitle(articleUpdateDto.title());
        article.setContent(articleUpdateDto.content());
        article.setUpdatedAt(articleUpdateDto.updatedAt());
        return article;
    }
}
