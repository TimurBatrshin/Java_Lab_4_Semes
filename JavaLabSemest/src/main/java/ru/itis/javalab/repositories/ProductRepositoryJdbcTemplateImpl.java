package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepositoryJdbcTemplateImpl implements ProductRepositories {
    private static final String SQL_FIND_ALL = "select * from product";
    private static final String SQL_GET_PRODUCT_RATING = "select * from product order by rating desc";
    private static final String SQL_GET_PRODUCT_BY_ID = "select * from product where product_id = ?";
    private static final String SQL_FIND_PRODUCT_BY_USER = "select name, description, price, rating, photo from \"userProductCart\" join cart c on c.id = \"userProductCart\".cart_id join \"productCart\" pC on c.id = pC.cart_id join product p on p.product_id = pC.product_id";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Product> productRowMapper = (row, i) -> Product.builder()
            .product_id(row.getLong("product_id"))
            .name(row.getString("name"))
            .description((row.getString("description")))
            .price(row.getInt("price"))
            .photo(row.getString("photo"))
            .build();

    private ResultSetExtractor<Product> productResultSetExtractor = resultSet -> {
        if (resultSet.next()) {
            return Product.builder()
                    .product_id(resultSet.getLong("product_id"))
                    .name(resultSet.getString("name"))
                    .description((resultSet.getString("description")))
                    .price(resultSet.getInt("price"))
                    .photo(resultSet.getString("photo"))
                    .build();
        }
        return null;
    };

    public ProductRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public List<User> findAll() {
        return null;
    }


    @Override
    public List<Product> findAll(int page, int size) {
        return null;
    }

    @Override
    public void save(Product entity) {

    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            products = namedParameterJdbcTemplate.query(SQL_FIND_ALL, productRowMapper);
        } catch (EmptyResultDataAccessException ignored) {
        }
        return products;
    }

    @Override
    public List<Product> getProductRating() {
        List<Product> products = new ArrayList<>();
        try {
            products = namedParameterJdbcTemplate.query(SQL_GET_PRODUCT_RATING, productRowMapper);
        } catch (EmptyResultDataAccessException ignored) {
        }
        return products;
    }

    @Override
    public Optional<Product> getAllProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> findAllProductsFromCartUser() {
        return null;
    }


    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(
                jdbcTemplate.query(
                        SQL_GET_PRODUCT_BY_ID,
                        new Object[]{id},
                        productResultSetExtractor
                )
        );
    }

    @Override
    public List<Product> FindProductByUser(Long product_id, Long user_id) {
        return jdbcTemplate.query(SQL_FIND_PRODUCT_BY_USER,  productRowMapper);
    }
}
