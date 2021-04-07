package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.ProductCart;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.*;


@Repository
public class ProductRepositoryJdbcTemplateImpl implements ProductRepositories {
    private static final String SQL_FIND_ALL = "select * from product";
    private static final String SQL_INSERT_CART = "insert into cart_user(cart_id, name, description, price, photo) values (:cartId, :name, :description, :price, :photo)";
    private static final String SQL_GET_PRODUCT_RATING = "select * from product order by rating desc";
    private static final String SQL_GET_PRODUCT_BY_ID = "select * from product where product_id = ?";
    private static final String SQL_ADD_TO_CART = "insert into product_cart (product_id, cart_id) values (:product_id, :cart_id)";
    private static final String SQL_FIND_PRODUCT_CART = "select name, description, price, rating, photo from product_cart pr join product p on pr.product_id = p.product_id and cart_id = :cart_id";

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
    public List<Product> findAllProductsFromCartUser() {
        return null;
    }


    @Override
    public Optional<Product> getProductById(Integer id) {
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
        return null;
    }

    @Override
    public void addToCart(Long cartId, Integer productId) {
        Map<String, Object> insertData = new HashMap<>();
        insertData.put("product_id", productId);
        insertData.put("cart_id", cartId);
        namedParameterJdbcTemplate.update(SQL_ADD_TO_CART, insertData);
    }

    @Override
    public Optional<Product> findProductCart(Integer cart_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("cart_id", cart_id);

        return Optional.ofNullable(namedParameterJdbcTemplate.query(SQL_FIND_PRODUCT_CART, map, productResultSetExtractor));
    }

    @Override
    public void setCartUser(Long cartId, String name, String description, int price, String photo) {
        Map<String, Object> map = new HashMap<>();
        map.put("cartId", cartId);
        map.put("name", name);
        map.put("description", description);
        map.put("price", price);
        map.put("photo", photo);
        namedParameterJdbcTemplate.update(SQL_INSERT_CART, map);
    }
}


