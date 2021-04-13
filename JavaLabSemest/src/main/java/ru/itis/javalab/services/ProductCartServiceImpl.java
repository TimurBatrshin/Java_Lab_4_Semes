package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.CartUser;
import ru.itis.javalab.repositories.ProductCartRepository;
import ru.itis.javalab.util.EmailUtil;
import ru.itis.javalab.util.MailsOrderGenerator;

import java.util.List;

@Service
public class ProductCartServiceImpl implements ProductCartService {
    @Autowired
    private MailsOrderGenerator mailsGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private ProductCartRepository productCartRepository;

    @Override
    public List<CartUser> getProductCart(Long id) {
        return productCartRepository.findProductCartBuUser(id);
    }

    @Override
    public List<CartUser> getSum(Long cart_id) {
        return productCartRepository.findSumCart(cart_id);
    }

    @Override
    public void sendMailOrder(List<CartUser> productCarts, String email) {
        String orderMail = mailsGenerator.getMailForOrder(serverUrl, productCarts);
        emailUtil.sendMail(email, "Заказ", from, orderMail);
    }


}
