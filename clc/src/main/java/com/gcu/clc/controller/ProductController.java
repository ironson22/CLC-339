package com.gcu.clc.controller;

import javax.validation.Valid;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductBusinessService service;
    /**
     * 
     * @param model the model being used on the page, used to send the products to the view
     * @return the products page
     */
    @GetMapping("/")
    public String productDisplay(Model model) {
        model.addAttribute("products", service.getProducts());
        return "products";
    }
/**
 * 
 * @param model the model being used on the page, used to give the product page a title and gives it a product model to use to create a new product
 * @return the product form page
 */
    @GetMapping("/productForm")
    public String showProductForm(Model model){
        model.addAttribute("title", "Product Creation");
        model.addAttribute("productModel", new ProductModel());
        return "productform";
    }
/**
 * 
 * @param product A product model, used to get the properties of the product that was made in the product form
 * @param bindResult Used to check if the product had any errors when being made
 * @param model The model being used, which uses the business layer to send the products over the products page for display
 * @return If their was validation issues, it sends you back to the product form, otherwise it will send you to the products page
 */
    @PostMapping("/createProduct")
    public String createProduct(@Valid ProductModel product, BindingResult bindResult, Model model){
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Product Creation");
            return "productform";
        }
        //Creates a new product and adds it to the products list
        // ProductBusinessService.addProduct(new ProductModel(product.getProductName(), product.getDescription(), product.getCategory(), product.getPrice()));
        //Sets the products to the attribute "products", which is used on the products page to display each product
        model.addAttribute("products", service.getProducts());
        return "products";
    }
}
