package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.Product;
import ru.itis.javalab.services.ProductService;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        List<Product> productsRating = productService.getProductRating();
        model.addAttribute("productsRating", productsRating);
        return "main";
    }
}
