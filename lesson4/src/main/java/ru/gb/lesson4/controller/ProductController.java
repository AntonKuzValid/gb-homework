package ru.gb.lesson4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson4.model.Product;
import ru.gb.lesson4.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("product", productService.findAll());
        return "product";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

}
