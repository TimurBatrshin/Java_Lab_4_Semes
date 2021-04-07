package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.models.Product;
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
    public Optional<Product> getProductCart(Integer cart_id) {
        return productRepositories.findProductCart(cart_id);
    }

    @Override
    public void getCartUser(Long cartId, String name, String description, int price, String photo) {
        productRepositories.setCartUser(cartId, name, description, price, photo);
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
    public void addToCart(Long cartId, Integer productId) {
        productRepositories.addToCart(cartId, productId);
    }

    @Override
    public List<Product> getAllProductsFromCartUser() {
        return productRepositories.findAllProductsFromCartUser();
    }



    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepositories.getProductById(id);
    }


}
