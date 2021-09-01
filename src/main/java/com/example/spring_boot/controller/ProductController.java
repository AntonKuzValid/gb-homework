package com.example.spring_boot.controller;

import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findById(){
        System.out.println("Контроллер");
        productService.show();
        return "product";
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
//    @GetMapping("/{id}")
//    public String deleteById(@PathVariable Integer id){
////        productService.deleteById(id);
//        return "redirect:/product";
//    }
}
