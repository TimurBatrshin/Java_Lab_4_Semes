package ru.itis.springboot.services;

import ru.itis.springboot.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    
    List<User> findAll();

    void banAll();

    void save(Long user_id, Long product_id);

}
