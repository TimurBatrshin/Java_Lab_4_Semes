package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springboot.models.Product;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.ProductService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String getIndexPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }


    @GetMapping("/add/{product-id}")
    public String getIndexPaget(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("product-id") Long product_id) {
        productService.save(product_id, userDetails.getUser().getId());
        return "redirect:/add";
    }

}
