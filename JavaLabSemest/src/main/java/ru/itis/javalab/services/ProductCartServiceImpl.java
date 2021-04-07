package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.CartUser;
import ru.itis.javalab.models.ProductCart;
import ru.itis.javalab.repositories.ProductCartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;

    @Override
    public List<CartUser> getProductCart(Long id) {
        return productCartRepository.findProductCartBuUser(id);
    }
}
