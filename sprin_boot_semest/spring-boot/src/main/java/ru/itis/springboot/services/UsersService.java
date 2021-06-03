package ru.itis.springboot.services;

import ru.itis.springboot.dto.UserDto;
import ru.itis.springboot.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
//    List<User> findUserByTemplate(String template);
    List<User> getAllUsers();

    List<User> rankings();

    Optional<User> getUserByEmail(String email);

    void banAll();
    Optional<User> findUserById(Long id);

    void Success(Long id);

}
