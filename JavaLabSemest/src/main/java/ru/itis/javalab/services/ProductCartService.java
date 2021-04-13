package ru.itis.javalab.services;

import ru.itis.javalab.models.CartUser;

import java.util.List;

public interface ProductCartService {
    List<CartUser> getProductCart(Long cart_id);
    List<CartUser> getSum(Long cart_id);
    void sendMailOrder(List<CartUser> productCarts, String email);
}
