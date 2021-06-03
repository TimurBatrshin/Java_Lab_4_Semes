package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.itis.javalab.dto.SignUpDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UserRepository;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public SignUpDto save(SignUpDto signUpDto) {
        User user = User.builder()
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .email(signUpDto.getEmail().trim())
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .role(User.Role.ADMIN)
                .state(User.State.ACTIVE)
                .build();
        userRepository.save(user);
        return signUpDto;
    }
}
