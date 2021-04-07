package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepositories extends CrudRepository<Product, Long> {
    List<Product> getAllProduct();
    List<Product> getProductRating();

    List<Product> findAllProductsFromCartUser();

    Optional<Product> getProductById(Integer id);

    List<Product> FindProductByUser(Long product_id, Long user_id);

    void addToCart(Long cartId, Integer productId);

    Optional<Product> findProductCart(Integer cart_id);

    void setCartUser(Long cartId, String name, String description, int price, String photo);

}
