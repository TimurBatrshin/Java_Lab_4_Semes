package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findFirstByEmailAndPassword(String email, String pass);
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByPassword(String password);
}
