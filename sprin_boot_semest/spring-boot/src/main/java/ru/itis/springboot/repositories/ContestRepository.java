package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springboot.models.Contests;

import java.util.Optional;

public interface ContestRepository extends JpaRepository<Contests, Long> {
}
