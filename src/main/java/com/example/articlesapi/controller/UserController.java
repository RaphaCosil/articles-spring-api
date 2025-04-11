package com.example.articlesapi.controller;

import com.example.articlesapi.contract.UserContract;
import com.example.articlesapi.dto.user.UserGetDto;
import com.example.articlesapi.dto.user.UserPostDto;
import com.example.articlesapi.dto.user.UserUpdateDto;
import com.example.articlesapi.exception.NotFoundException;
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
    public ResponseEntity<UserGetDto> createUser(
            UserPostDto userPostDto,
            BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().build();
            } else {
                userService.saveUser(userPostDto);
                ResponseEntity.ok(
                        userService.findByEmail(userPostDto.getEmail())
                );
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return null;
    }

    @Override
    public ResponseEntity<List<UserGetDto>> getAllUsers() {
        return ResponseEntity.ok(
                userService.findAll()
        );
    }

    @Override
    public ResponseEntity<UserGetDto> getUserById(int id) {
        return ResponseEntity.ok(
                userService.findById(id)
        );
    }

    @Override
    public ResponseEntity<UserGetDto> updateUser(int id, UserUpdateDto userUpdateDto) {
        try {
            userService.update(id, userUpdateDto);
            return ResponseEntity.ok(
                    userService.findById(id)
            );
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(int id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }
    }
}
