package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.Product;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.ProductService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AddToCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/add/{product-id}", method = RequestMethod.GET)
    public String getProfilePage(Model model, @PathVariable("product-id") Long id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Optional<User> user = usersService.findUserByEmail(email);
        Optional<Product> products = productService.getProductById(id);
        List<Product> productsUser = productService.getProductByUser(products.get().getProduct_id(), user.get().getId());
        model.addAttribute("productsUser", productsUser);
        return "shoppingCart";
    }
}

