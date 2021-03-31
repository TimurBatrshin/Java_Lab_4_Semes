package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.ProductRepositories;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepositories productRepositories;


    public ProductServiceImpl(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @Override
    public List<Product> getProductByUser(Long product_id, Long user_id) {
        return productRepositories.FindProductByUser(product_id, user_id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositories.getAllProduct();
    }

    @Override
    public List<Product> getProductRating() {
        return productRepositories.getProductRating();
    }

    @Override
    public List<Product> getAllProductsFromCartUser() {
        return productRepositories.findAllProductsFromCartUser();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepositories.getProductById(id);
    }


}
