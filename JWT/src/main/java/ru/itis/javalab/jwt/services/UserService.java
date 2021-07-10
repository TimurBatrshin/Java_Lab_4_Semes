package ru.itis.javalab.jwt.services;

import ru.itis.javalab.jwt.models.User;

public interface UserService {
    User findUserById(Long id);
}
