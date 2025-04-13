package com.example.articlesapi.service;

import com.example.articlesapi.dto.user.UserGetDto;
import com.example.articlesapi.dto.user.UserPostDto;
import com.example.articlesapi.dto.user.UserUpdateDto;
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

    public void save(UserPostDto userPostDto) {
        userRepository.save(parseUserToUserPostDto(userPostDto));
    }

    public void update(int id, UserUpdateDto userUpdateDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        existingUser = parseUserToUserUpdateDto(existingUser, userUpdateDto);
        userRepository.save(existingUser);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<UserGetDto> findAll() {
        List<User> users = userRepository.findAll();
        List <UserGetDto> userGetDtos = listOf();
        for (User user : users) {
            userGetDtos.add(parseUserGetDtoToUser(user));
        }
        return userGetDtos;
    }

    public UserGetDto findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return parseUserGetDtoToUser(user.get());
        } else {
            throw new NotFoundException();
        }
    }

    public UserGetDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return parseUserGetDtoToUser(user.get());
        } else {
            throw new NotFoundException();
        }
    }

    public User parseUserToUserPostDto(UserPostDto userPostDto) {
        User user = new User();
        user.setName(userPostDto.name());
        user.setEmail(userPostDto.email());
        user.setPassword(userPostDto.password());
        user.setRole(userPostDto.role());
        user.setStudyArea(userPostDto.studyArea());
        user.setCreatedAt(Date.valueOf(LocalDate.now()));
        return user;
    }
    public User parseUserToUserUpdateDto(User user, UserUpdateDto userUpdateDto) {
        user.setName(userUpdateDto.name());
        user.setEmail(userUpdateDto.email());
        user.setPassword(userUpdateDto.password());
        user.setRole(userUpdateDto.role());
        user.setStudyArea(userUpdateDto.studyArea());
        user.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return user;
    }

    private UserGetDto parseUserGetDtoToUser(User user) {
        return new UserGetDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getStudyArea(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    private Iterable<UserGetDto> parseUserGetDtoToUserGetDto(List<User> users) {
        return users.stream().map(this::parseUserGetDtoToUser).toList();
    }
}
