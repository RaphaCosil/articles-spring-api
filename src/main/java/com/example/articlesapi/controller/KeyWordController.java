package com.example.articlesapi.controller;

import com.example.articlesapi.contract.KeyWordContract;
import com.example.articlesapi.dto.keyword.KeyWordGetDto;
import com.example.articlesapi.dto.keyword.KeyWordPostDto;
import com.example.articlesapi.exception.BadRequestException;
import com.example.articlesapi.service.KeyWordService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeyWordController implements KeyWordContract {

    KeyWordService keyWordService;

    public KeyWordController(KeyWordService keyWordService) {
        this.keyWordService = keyWordService;
    }

    @Override
    public ResponseEntity<Void> save(KeyWordPostDto keyWordPostDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(
                    bindingResult.getFieldErrors().get(0).getDefaultMessage()
            );
        } else {
            keyWordService.save(keyWordPostDto);
            return ResponseEntity.status(201).build();
        }
    }

    @Override
    public ResponseEntity<List<KeyWordGetDto>> findAll() {
        return ResponseEntity.ok(keyWordService.findAll());
    }

    @Override
    public ResponseEntity<KeyWordGetDto> findById(int id) {
        return ResponseEntity.ok(keyWordService.findById(id));
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        keyWordService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<KeyWordGetDto>> findByArticleId(int articleId) {
        return ResponseEntity.ok(keyWordService.findByArticleId(articleId));
    }
}
