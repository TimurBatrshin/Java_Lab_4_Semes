package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface UsersService {
    List<User> getAllUser();
    List<UserDto> getAllUser(int page, int size);
    Optional<User> findUserByEmailAndPassword(String email, String password);
    Optional<User> getUser(Long userId);

    Optional<User> findUserByEmail(String email);

    void banAll();

}
