package ru.itis.springboot.services;

import ru.itis.springboot.models.User;

import java.util.Optional;

public interface SignInService {
    Optional<User> findUserByEmail(String email);

}
