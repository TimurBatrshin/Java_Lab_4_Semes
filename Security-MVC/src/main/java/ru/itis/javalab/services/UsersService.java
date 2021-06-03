package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    void banAll();

}
