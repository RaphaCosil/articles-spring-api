package com.example.articlesapi.controller;

import com.example.articlesapi.contract.UserContract;
import com.example.articlesapi.dto.user.UserGetDto;
import com.example.articlesapi.dto.user.UserPostDto;
import com.example.articlesapi.dto.user.UserUpdateDto;
import com.example.articlesapi.exception.BadRequestException;
import com.example.articlesapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public class UserController implements UserContract {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> save(
            UserPostDto userPostDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(
                    bindingResult.getFieldError().getDefaultMessage()
            );
        }
        userService.save(userPostDto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<List<UserGetDto>> findAll() {
        return ResponseEntity.ok(
                userService.findAll()
        );
    }

    @Override
    public ResponseEntity<UserGetDto> findById(int id) {
        return ResponseEntity.ok(
                userService.findById(id)
        );
    }

    @Override
    public ResponseEntity<Void> update(int id, UserUpdateDto userUpdateDto) {
        userService.update(id, userUpdateDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
