package com.example.mongodbgridfs.service;

import com.example.mongodbgridfs.dto.SignUpForm;
import com.example.mongodbgridfs.model.User;
import com.example.mongodbgridfs.repositorises.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void signUp(SignUpForm signUpForm) {
        User newUser = User.builder()
                .name(signUpForm.getName())
                .email(signUpForm.getEmail().trim())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();
        userRepository.save(newUser);
    }
}
