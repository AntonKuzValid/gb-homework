package com.example.spring_boot.controller;

import com.example.spring_boot.model.Product;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String selectAll(Model model){
        model.addAttribute("product", productService.selectAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        productService.removeFromDB(id);
        return "redirect:/product";
    }

    @PostMapping
    public String create(@ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/product";
        }
        return "redirect:/product";
    }

}
