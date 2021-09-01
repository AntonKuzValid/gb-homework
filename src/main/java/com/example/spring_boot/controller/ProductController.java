package com.example.spring_boot.controller;

import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String deleteById(@PathVariable Integer id){
        productService.removeFromDB(id);
        return "redirect:/product";
    }

//    @PostMapping
//    public String create(@ModelAttribute("product") @Valid Products product, BindingResult bindingResult){
//
//        if (bindingResult.hasErrors()) {
//            System.out.println("Errors - " + bindingResult.getAllErrors());
//            return "redirect:/product";
//        }
////        productService.save(product);
//        return "redirect:/product";
//    }
//
}
