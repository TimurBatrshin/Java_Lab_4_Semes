package ru.itis.javalab.repositories;

import ru.itis.javalab.models.CartUser;

import java.util.List;
import java.util.Optional;

public interface ProductCartRepository {
    List<CartUser> findProductCartBuUser(Long cart_id);
    List<CartUser> findSumCart(Long cart_id);

    void sendOrder();
}
