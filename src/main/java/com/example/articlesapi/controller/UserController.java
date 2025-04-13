package com.example.articlesapi.controller;

import com.example.articlesapi.contract.UserContract;
import com.example.articlesapi.dto.user.UserGetDto;
import com.example.articlesapi.dto.user.UserPostDto;
import com.example.articlesapi.dto.user.UserUpdateDto;
import com.example.articlesapi.exception.BadRequestException;
import com.example.articlesapi.exception.InternalServerException;
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
                throw new BadRequestException();
            } else {
                userService.save(userPostDto);
                ResponseEntity.ok(
                        userService.findByEmail(userPostDto.email())
                );
            }
        } catch (Exception e) {
            throw new InternalServerException();
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
        try {
            return ResponseEntity.ok(
                    userService.findById(id)
            );
        } catch (NotFoundException e) {
            throw new NotFoundException();
        }
    }

    @Override
    public ResponseEntity<UserGetDto> updateUser(int id, UserUpdateDto userUpdateDto) {
        try {
            userService.update(id, userUpdateDto);
            return ResponseEntity.ok(
                    userService.findById(id)
            );
        } catch (NotFoundException e) {
            throw new NotFoundException();
        } catch (Exception e) {
            throw new InternalServerException();
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
