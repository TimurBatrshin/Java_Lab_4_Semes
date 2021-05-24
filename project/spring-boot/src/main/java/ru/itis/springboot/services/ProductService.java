package ru.itis.springboot.services;

import ru.itis.springboot.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Long product_id, Long user_id);
    List<Product> getCartUser(Long user_id);
}
