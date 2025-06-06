package com.example.articlesapi.service;

import com.example.articlesapi.dto.keyword.KeyWordGetDto;
import com.example.articlesapi.dto.keyword.KeyWordPostDto;
import com.example.articlesapi.entity.Article;
import com.example.articlesapi.entity.KeyWord;
import com.example.articlesapi.exception.NotFoundException;
import com.example.articlesapi.repository.ArticleRepository;
import com.example.articlesapi.repository.KeyWordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeyWordService {
    KeyWordRepository keyWordRepository;
    ArticleRepository articleRepository;

    public KeyWordService(KeyWordRepository keyWordRepository, ArticleRepository articleRepository) {
        this.keyWordRepository = keyWordRepository;
        this.articleRepository = articleRepository;
    }

    public void save(KeyWordPostDto keyWordPostDto) {
        keyWordRepository.save(parseKeyWordToKeyWordPostDto(keyWordPostDto));
    }

    public void deleteById(int id) {
        keyWordRepository.deleteById(id);
    }

    public List<KeyWordGetDto> findAll() {
        return keyWordRepository.findAll().stream().map(this::parseKeyWordToKeyWordGetDto).toList();
    }

    public KeyWordGetDto findById(int id) {
        Optional<KeyWord> keyWord = keyWordRepository.findById(id);
        if (keyWord.isPresent()) {
            return parseKeyWordToKeyWordGetDto(keyWord.get());
        } else {
            throw new NotFoundException();
        }
    }

    public List<KeyWordGetDto> findByArticleId(int articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(NotFoundException::new);

        return parseKeyWordToKeyWordGetDto(
                keyWordRepository.findByArticle(article)
        );
    }

    private KeyWord parseKeyWordToKeyWordPostDto(KeyWordPostDto keyWordPostDto) {
        Article article = articleRepository.findById(keyWordPostDto.articleId()).orElse(null);
        if (article == null) {
            throw new NotFoundException();
        }
        KeyWord keyWord = new KeyWord();
        keyWord.setArticle(article);
        keyWord.setContent(keyWordPostDto.content());
        return keyWord;
    }

    private KeyWordGetDto parseKeyWordToKeyWordGetDto(KeyWord keyWord) {
        return new KeyWordGetDto(
                keyWord.getKeyWordId(),
                keyWord.getArticle().getArticleId(),
                keyWord.getContent(),
                keyWord.getCreatedAt(),
                keyWord.getUpdatedAt()
        );
    }

    private List<KeyWordGetDto> parseKeyWordToKeyWordGetDto(List<KeyWord> keyWords) {
        return keyWords.stream().map(this::parseKeyWordToKeyWordGetDto).toList();
    }
}
