package ru.itis.javalab.services;

import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductRating();

    List<Product> getAllProductsFromCartUser();

    Optional<Product> getProductById(Long id);
    List<Product> getProductByUser(Long product_id, Long user_id);
}
