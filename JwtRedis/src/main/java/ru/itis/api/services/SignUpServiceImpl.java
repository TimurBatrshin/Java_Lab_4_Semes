package ru.itis.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.dto.SignUpDto;
import ru.itis.api.models.User;
import ru.itis.api.repository.UsersRepository;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User save(SignUpDto signUpDto) {
        User user = User.builder()
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .email(signUpDto.getEmail().trim())
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .role(User.Role.ADMIN)
                .state(User.State.ACTIVE)
                .build();
        return usersRepository.save(user);
    }
}
