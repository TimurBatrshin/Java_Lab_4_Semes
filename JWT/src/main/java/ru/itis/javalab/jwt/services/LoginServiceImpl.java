package ru.itis.javalab.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.jwt.dto.LoginDto;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.repositories.UsersRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UsersRepository usersRepository;

    public LoginServiceImpl(PasswordEncoder passwordEncoder,
                            UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public User login(LoginDto loginDto) {
        User loginUser = usersRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() ->
                        new UsernameNotFoundException("user with this email not found"));

        return passwordEncoder
                .matches(loginDto.getPassword(), loginUser.getPassword()) ? loginUser : null;
    }
}
