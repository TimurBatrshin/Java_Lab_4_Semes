package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springboot.models.Product;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.ProductRepository;
import ru.itis.springboot.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

//    @Override
//    public void save(Long product_id, Long user_id) {
//        Optional<User> users = usersRepository.findById(user_id);
//        Optional<Product> products = productRepository.findById(product_id);
//        List<Product> productList = users.get().getProducts();
//        productList.add(products.get());
//        users.get().setProducts(productList);
//        usersRepository.save(users.get());
//    }

    @Override
    public void save(Long product_id, Long user_id) {
        Optional<User> users = usersRepository.findById(user_id);
        Optional<Product> products = productRepository.findById(product_id);
        List<User> userList = products.get().getUser();
        userList.add(users.get());
        products.get().setUser(userList);
        productRepository.save(products.get());
    }

    @Override
    public List<Product> getCartUser(Long user_id) {
        return productRepository.findCart(user_id);
    }
}
