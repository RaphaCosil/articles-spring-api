package com.example.articlesapi.contract;

import com.example.articlesapi.dto.UserGetDto;
import com.example.articlesapi.dto.UserPostDto;
import com.example.articlesapi.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@Tag(name = "User")
public interface UserContract {

    @PostMapping("/")
    @Operation(summary = "Create a new user", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<UserGetDto> createUser(
        @Valid @RequestBody UserPostDto userPostDto,
        BindingResult bindingResult
    );

    @GetMapping("/")
    @Operation(summary = "Get all users", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<UserGetDto>> getAllUsers();

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<UserGetDto> getUserById(@PathVariable(value = "id") int id);

    @PutMapping("/{id}")
    @Operation(summary = "Update user by id", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<UserGetDto> updateUser(@PathVariable(value = "id") int id, @Valid @RequestBody UserUpdateDto userUpdateDto);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteUser(@PathVariable(value = "id") int id);
}
