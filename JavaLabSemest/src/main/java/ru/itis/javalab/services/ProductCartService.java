package ru.itis.javalab.services;

import ru.itis.javalab.models.CartUser;

import java.util.List;
import java.util.Optional;

public interface ProductCartService {
    List<CartUser> getProductCart(Long cart_id);
    List<CartUser> getSum(Long cart_id);

    void sendMail(String confirmCode, String email);
}
