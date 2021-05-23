package ru.itis.springboot.services;

import ru.itis.springboot.models.Contests;

import java.util.List;
import java.util.Optional;

public interface ContestService {
    List<Contests> findAll();

    Optional<Contests> findById(Long id);
}
