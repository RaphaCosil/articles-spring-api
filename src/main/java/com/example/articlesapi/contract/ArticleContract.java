package com.example.articlesapi.contract;

import com.example.articlesapi.dto.article.ArticleGetDto;
import com.example.articlesapi.dto.article.ArticlePostDto;
import com.example.articlesapi.dto.article.ArticleUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArticleContract {
    @PostMapping("/")
    @Operation(summary = "Create a new article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Article created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> save(
            @Valid @RequestBody ArticlePostDto articlePostDto,
            BindingResult bindingResult
    );

    @GetMapping("/")
    @Operation(summary = "Get all articles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ArticleGetDto>> findAll();

    @GetMapping("/{id}")
    @Operation(summary = "Get article by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Article not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ArticleGetDto> findById(@PathVariable(value = "id") int id);

    @PutMapping("/{id}")
    @Operation(summary = "Update article by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article updated successfully"),
            @ApiResponse(responseCode = "404", description = "Article not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> update(
            @PathVariable(value = "id") int id,
            @Valid @RequestBody ArticleUpdateDto articleUpdateDto
            );

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete article by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Article not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> delete(@PathVariable(value = "id") int id);

    @GetMapping("/title/{title}")
    @Operation(summary = "Get all articles by title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ArticleGetDto>> findByTitleContaining(@PathVariable(value = "title") String title);

    @GetMapping("/content/{content}")
    @Operation(summary = "Get all articles by content")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ArticleGetDto>> findByContentContaining(@PathVariable(value = "content") String content);

    @GetMapping("/keywords/{keywords}")
    @Operation(summary = "Get all articles by keywords")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ArticleGetDto>> findByKeywords(@PathVariable(value = "keywords") List<String> keywords);

    @GetMapping("/keywords-filter/{keywords}")
    @Operation(summary = "Get all articles by keywords")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ArticleGetDto>> findByKeywordsFilter(@PathVariable(value = "keywords") List<String> keywords);
}
