package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
