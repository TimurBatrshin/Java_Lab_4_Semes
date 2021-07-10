package ru.itis.javalab.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.jwt.models.RefreshToken;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByFingerprint(String fingerPrint);

}
