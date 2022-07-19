package com.example.mongodbgridfs.service;

import com.example.mongodbgridfs.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Long userId);
}
