package com.example.articlesapi.contract;

import com.example.articlesapi.dto.keyword.KeyWordGetDto;
import com.example.articlesapi.dto.keyword.KeyWordPostDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/keywords")
@Tag(name = "KeyWords")
public interface KeyWordContract {
    @PostMapping("/")
    @Operation(summary = "Create a new keyword")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Keyword created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> save(
            @Valid @RequestBody KeyWordPostDto keyWordPostDto,
            BindingResult bindingResult
    );

    @GetMapping("/")
    @Operation(summary = "Get all keywords")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Keywords retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<KeyWordGetDto>> findAll();

    @GetMapping("/{id}")
    @Operation(summary = "Get keyword by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Keyword retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Keyword not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<KeyWordGetDto> findById(@PathVariable(value = "id") int id);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete keyword by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Keyword deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Keyword not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> delete(@PathVariable(value = "id") int id);

    @GetMapping("/article/{articleId}")
    @Operation(summary = "Get all keywords by article id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Keywords retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Keywords not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<KeyWordGetDto>> findByArticleId(@PathVariable(value = "articleId") int articleId);
}
