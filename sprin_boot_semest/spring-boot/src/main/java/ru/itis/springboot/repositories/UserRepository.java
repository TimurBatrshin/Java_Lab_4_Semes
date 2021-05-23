package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByPointDesc();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);

}
