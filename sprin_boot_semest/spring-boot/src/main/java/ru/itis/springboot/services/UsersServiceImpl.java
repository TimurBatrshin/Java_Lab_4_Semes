package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> rankings() {
        return userRepository.findAllByOrderByPointDesc();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void banAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (!user.isAdmin()) {
                user.setState(User.State.BANNED);
                userRepository.save(user);
            }
        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


}
