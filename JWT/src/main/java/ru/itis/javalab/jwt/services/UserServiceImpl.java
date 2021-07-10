package ru.itis.javalab.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User findUserById(Long id) {
        return usersRepository.findUserById(id);
    }
}
