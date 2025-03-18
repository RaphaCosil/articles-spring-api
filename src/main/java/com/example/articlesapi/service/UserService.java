package com.example.articlesapi.service;

import com.example.articlesapi.dto.UserGetDto;
import com.example.articlesapi.dto.UserPostDto;
import com.example.articlesapi.dto.UserUpdateDto;
import com.example.articlesapi.entity.User;
import com.example.articlesapi.exception.NotFoundException;
import com.example.articlesapi.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserPostDto userPostDto) {
        userRepository.save(parseUserToUserPostDto(userPostDto));
    }

    public List<UserGetDto> findAll() {
        List<User> users = userRepository.findAll();
        List <UserGetDto> userGetDtos = listOf();
        for (User user : users) {
            userGetDtos.add(parseUserGetDtoToUser(user));
        }
        return userGetDtos;
    }

    public UserGetDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return parseUserGetDtoToUser(user.get());
        } else {
            throw new NotFoundException();
        }
    }

    public UserGetDto findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return parseUserGetDtoToUser(user.get());
        } else {
            throw new NotFoundException();
        }
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void update(int id, UserUpdateDto userUpdateDto) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser = parseUserToUserUpdateDto(userUpdateDto);
            userRepository.save(existingUser);
        } else {
            throw new NotFoundException();
        }
    }

    public User parseUserToUserPostDto(UserPostDto userPostDto) {
        User user = new User();
        user.setName(userPostDto.getName());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());
        user.setRole(userPostDto.getRole());
        user.setStudyArea(userPostDto.getStudyArea());
        user.setCreatedAt(Date.valueOf(LocalDate.now()));
        return user;
    }
    public User parseUserToUserUpdateDto(UserUpdateDto userUpdateDto) {
        User user = new User();
        user.setName(userUpdateDto.getName());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(userUpdateDto.getPassword());
        user.setRole(userUpdateDto.getRole());
        user.setStudyArea(userUpdateDto.getStudyArea());
        user.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return user;
    }

    public UserGetDto parseUserGetDtoToUser(User user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUserId(user.getUserId());
        userGetDto.setName(user.getName());
        userGetDto.setEmail(user.getEmail());
        userGetDto.setPassword(user.getPassword());
        userGetDto.setRole(user.getRole());
        userGetDto.setStudyArea(user.getStudyArea());
        userGetDto.setCreatedAt(user.getCreatedAt());
        userGetDto.setUpdatedAt(user.getUpdatedAt());
        return userGetDto;
    }

}
