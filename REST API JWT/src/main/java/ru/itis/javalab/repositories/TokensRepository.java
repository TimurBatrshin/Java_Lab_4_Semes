package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Token;

public interface TokensRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
