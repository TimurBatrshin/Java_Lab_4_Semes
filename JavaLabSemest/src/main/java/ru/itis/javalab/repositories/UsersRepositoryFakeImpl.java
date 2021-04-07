package ru.itis.javalab.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

@Profile("dev")
@Repository
public class UsersRepositoryFakeImpl implements UsersRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(int page, int size) {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.of(User.builder()
                .first_name("fake")
                .last_name("fake")
                .build());
    }

    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String pass) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.empty();
    }

}
