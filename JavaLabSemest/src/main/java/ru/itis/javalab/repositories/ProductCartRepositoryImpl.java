package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.CartUser;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductCartRepositoryImpl implements ProductCartRepository {
    //language=SQL
    private static final String SQL_FIND_PRODUCT_CART = "select * from cart_user where cart_id = :cart_id";
    //language=SQL
    private static final String SQL_FIND_SUM_CART = " select sum(price) from cart_user where cart_id = :cart_id";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public ProductCartRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    private RowMapper<CartUser> cartUserRowMapper = (resultSet, i) ->
            CartUser.builder()
                    .cart_id(resultSet.getLong("cart_id"))
                    .name(resultSet.getString("name"))
                    .description(resultSet.getString("description"))
                    .price(resultSet.getInt("price"))
                    .photo(resultSet.getString("photo"))
                    .build();

    private ResultSetExtractor<CartUser> productResultSetExtractor = resultSet -> {
        if (resultSet.next()) {
            return CartUser.builder()
                    .cart_id(resultSet.getLong("cart_id"))
                    .name(resultSet.getString("name"))
                    .description((resultSet.getString("description")))
                    .price(resultSet.getInt("price"))
                    .photo(resultSet.getString("photo"))
                    .build();
        }
        return null;
    };

    @Override
    public List<CartUser> findProductCartBuUser(Long cart_id) {
        List<CartUser> products = new ArrayList<>();
        try {
            products = namedParameterJdbcTemplate.query(SQL_FIND_PRODUCT_CART, Collections.singletonMap("cart_id", cart_id), cartUserRowMapper);
        } catch (EmptyResultDataAccessException ignored) {
        }
        return products;
    }

    @Override
    public List<CartUser> findSumCart(Long cart_id) {
        List<CartUser> products = new ArrayList<>();
        try {
            products = namedParameterJdbcTemplate.query(SQL_FIND_SUM_CART, Collections.singletonMap("cart_id", cart_id), cartUserRowMapper);
        } catch (EmptyResultDataAccessException ignored) {
        }
        return products;
    }

    @Override
    public void sendOrder() {

    }
}


