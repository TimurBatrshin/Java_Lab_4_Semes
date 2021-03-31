package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    List<User> findAll();
    List<T> findAll(int page, int size);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    Optional<T> findById(ID id);
}
