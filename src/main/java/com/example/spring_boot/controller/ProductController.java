package com.example.spring_boot.controller;

import com.example.spring_boot.model.Product;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("product", productService.findAll());
        return "product";
    }

    @PostMapping
    public String create(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            System.out.println("Errors - " + bindingResult.getAllErrors());
            return "redirect:/product";
        }

        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Integer id){
        productService.deleteById(id);
        return "redirect:/product";
    }
}
