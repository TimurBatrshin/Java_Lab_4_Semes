package com.example.mongodbgridfs.service;

import com.example.mongodbgridfs.model.User;
import com.example.mongodbgridfs.repositorises.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
