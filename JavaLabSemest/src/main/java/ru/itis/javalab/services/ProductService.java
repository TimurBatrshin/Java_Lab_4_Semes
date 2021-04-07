package ru.itis.javalab.services;

import ru.itis.javalab.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductRating();

    void addToCart(Long cartId, Integer productId);

    List<Product> getAllProductsFromCartUser();
    Optional<Product> getProductById(Integer id);
    List<Product> getProductByUser(Long product_id, Long user_id);
    Optional<Product> getProductCart(Integer cart_id);

    void getCartUser(Long cartId, String name, String description, int price, String photo);
}
