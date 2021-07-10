package ru.itis.javalab.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.jwt.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findUserById(Long id);

}
