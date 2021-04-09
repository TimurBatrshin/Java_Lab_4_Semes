package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.CartUser;
import ru.itis.javalab.models.ProductCart;
import ru.itis.javalab.repositories.ProductCartRepository;
import ru.itis.javalab.util.EmailUtil;
import ru.itis.javalab.util.MailsGenerator;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public List<CartUser> getProductCart(Long id) {
        return productCartRepository.findProductCartBuUser(id);
    }

    @Override
    public List<CartUser> getSum(Long cart_id) {
        return productCartRepository.findSumCart(cart_id);
    }

    @Override
    public void sendMail(String confirmCode, String email) {
        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, confirmCode);
        emailUtil.sendMail(email, "Регистрация", from, confirmMail);
    }


}
