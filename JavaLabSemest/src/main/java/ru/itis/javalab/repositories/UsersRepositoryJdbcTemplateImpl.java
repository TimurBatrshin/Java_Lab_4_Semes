package ru.itis.javalab.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.*;

@Profile("master")
@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "select * from users where email = :email limit 1";
    private static final String SQL_FIND_ONE_BY_PASSWORD = "select * from users where password = :password limit 1";
    private static final String SQL_INSERT_USER = "insert into users (first_name, last_name, email, phone, password, confirm_code) values (:first_name, :last_name, :email, :phone, :password, :confirm_code)";
    private static final String SQL_SELECT = "select * from users";
    private static final String SQL_SELECT_BY_ID = "select * from users where id = :id limit 1";
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users order by id limit :limit offset :offset;";
    private static final String SQL_ADD_CART = "insert into cart () values()";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .email(row.getString("email").trim())
            .phone(row.getString("phone"))
            .password(row.getString("password"))
            .confirmCode(row.getString("confirm_code"))
            .cartId(row.getLong("cart_id"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try {
            return Optional.of(namedParameterJdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL, Collections.singletonMap("email", email), userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public List<User> findAll() {
        return namedParameterJdbcTemplate.query(SQL_SELECT, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);
    }

    @Override
    public void save(User entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("first_name", entity.getFirst_name());
        params.put("last_name", entity.getLast_name());
        params.put("email", entity.getEmail().trim());
        params.put("phone", entity.getPhone());
        params.put("password", entity.getPassword());
        params.put("confirm_code", entity.getConfirmCode());
        namedParameterJdbcTemplate.update(SQL_INSERT_USER, params);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = namedParameterJdbcTemplate.queryForObject(SQL_SELECT_BY_ID, Collections.singletonMap("id", id), userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }

        return Optional.ofNullable(user);
    }
}
