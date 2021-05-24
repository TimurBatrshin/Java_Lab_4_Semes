package ru.itis.springboot.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.Product;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.ProductService;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    private String getCartPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<Product> products = productService.getCartUser(userDetails.getUser().getId());
        model.addAttribute("products", products);
        return "cart";
    }
}
