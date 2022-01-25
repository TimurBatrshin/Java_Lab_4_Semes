package ru.itis.api.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository  {
    void save(String token);

    boolean exists(String token);
}
