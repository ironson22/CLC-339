package com.gcu.clc.controller;

import javax.validation.Valid;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/")
    public String productDisplay(Model model) {
        model.addAttribute("products", ProductBusinessService.getProducts());
        return "products";
    }

    @GetMapping("/productForm")
    public String showProductForm(Model model){
        model.addAttribute("title", "Product Creation");
        model.addAttribute("productModel", new ProductModel());
        return "productform";
    }

    @PostMapping("/createProduct")
    public String createProduct(@Valid ProductModel product, BindingResult bindResult, Model model){
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Product Creation");
            return "productform";
        }
        ProductBusinessService.addProduct(new ProductModel(product.getProductName(), product.getDescription(), product.getCategory(), product.getPrice()));
        model.addAttribute("products", ProductBusinessService.getProducts());
        return "products";
    }
}
