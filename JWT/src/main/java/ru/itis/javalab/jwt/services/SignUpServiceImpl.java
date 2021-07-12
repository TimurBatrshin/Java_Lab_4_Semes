package ru.itis.javalab.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.jwt.dto.UserForm;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    public SignUpServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signUp(UserForm userForm) {
        User newUser = User.builder()
                .userName(userForm.getUserName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(User.Role.STUDENT)
                .state(User.State.ACTIVE)
                .status(User.Status.CONFIRMED)
                .build();

        return usersRepository.save(newUser);
    }
}
