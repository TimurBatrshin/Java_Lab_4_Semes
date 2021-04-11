package ru.itis.javalab.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.javalab.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<User> getAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public List<UserDto> getAllUser(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }


    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return usersRepository.findFirstByEmailAndPassword(email, password);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return usersRepository.findById(userId);
    }


    @Override
    public Optional<User> findUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }

}
