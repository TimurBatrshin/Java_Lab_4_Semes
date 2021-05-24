package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.springboot.dto.SignUpForm;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void save(SignUpForm signUpForm) {
        User newUser = User.builder()
                .first_name(signUpForm.getFirst_name())
                .last_name(signUpForm.getLast_name())
                .email(signUpForm.getEmail())
                .hashPassword(passwordEncoder.encode(signUpForm.getPassword()))
                .role(User.Role.USER)
                .state(User.State.ACTIVE)

                .build();
        usersRepository.save(newUser);
    }
}
