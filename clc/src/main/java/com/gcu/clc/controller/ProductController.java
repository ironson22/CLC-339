package com.gcu.clc.controller;

import javax.validation.Valid;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;
import com.gcu.clc.model.SearchModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("openingText", "Products");
        return "products";
    }
    
    @GetMapping("/search/{product}")
    public String searchProducts(@PathVariable("product") String productName, Model model){
        model.addAttribute("products", service.searchProductsByName(productName));
        model.addAttribute("openingText", "Results for '" + productName + "'");
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
    @RequestMapping(path="/createProduct", method={RequestMethod.GET, RequestMethod.POST})
    public String createProduct(@Valid ProductModel product, BindingResult bindResult, Model model){
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Product Creation");
            return "productform";
        }
        //Creates a new product and adds it to database
        if(service.createProduct(product)){
        //Sets the products to the attribute "products", which is used on the products page to display each product
            model.addAttribute("products", service.getProducts());
            return "products";
        }
        return "productform";
    }

    @GetMapping("/edit/{id}/")
    public String editProduct(@PathVariable("id") Long id, Model model){
        System.out.println(id);
        ProductModel productModel = service.findById(id);
        System.out.println(productModel.getProductName());
        model.addAttribute("productModel", productModel);
        System.out.println(productModel.getProductId());
        return "updateform";
    } 

    @RequestMapping(path="/edit/{id}/updating", method = {RequestMethod.GET, RequestMethod.PUT})
    public String changeProduct(@PathVariable("id") Long id, ProductModel productModel, BindingResult result, Model model) {
        System.out.print(productModel.getProductName());
        productModel.setProductId(id);

        if (result.hasErrors()) {
            model.addAttribute("title", "Edit Product");
            return "updateform";
        }
        if(service.updateProduct(productModel)){
            model.addAttribute("products", service.getProducts());
            return "redirect:/products/";
        }
        return "updateform";
    }
/**
 * GetMapping for delete method to call removeProduct
 * @param id product id
 * @return products page
 */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        //Testing
        System.out.println(id);
        removeProduct(id);
        return "redirect:/products/";
    }
    /**
     * Method to remove a product using the ID passed in from the deleteProduct method
     * @param id products ID
     * @return products page
     */
    @DeleteMapping("/deleting")
    public String removeProduct(Long id) {
        service.deleteProduct(id);
        return "redirect:/products/";
    }
}
