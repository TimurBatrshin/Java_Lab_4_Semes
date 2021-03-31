package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepositories extends CrudRepository<Product, Long> {
    List<Product> getAllProduct();
    List<Product> getProductRating();

    Optional<Product> getAllProduct(Long id);

    List<Product> findAllProductsFromCartUser();

    Optional<Product> getProductById(Long id);

    List<Product> FindProductByUser(Long product_id, Long user_id);

}
