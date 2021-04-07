package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.CartUser;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.ProductCartService;
import ru.itis.javalab.services.ProductService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductCartController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductCartService productCartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getProfilePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Optional<User> user = usersService.findUserByEmail(email);
        List<CartUser> productCarts = productCartService.getProductCart(user.get().getCartId());
        model.addAttribute("productCarts",productCarts);
        return "shoppingCart";
    }
}
