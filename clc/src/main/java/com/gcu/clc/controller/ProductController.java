package com.gcu.clc.controller;

import java.util.List;

import javax.validation.Valid;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;
import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductBusinessService service;
    @Autowired
    private EurekaClient eurekaClient;
    /**
     * Displays all products in the server
     * @param model the model being used on the page, used to send the products to the view
     * @return the products page
     */
    @GetMapping("/")
    public String productDisplay(Model model) {
        //Gets the application to be used (the REST API service)
        Application application = eurekaClient.getApplication("product-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        //Gets information from the application and creates a URL from it
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        System.out.println(port);
        String url = "http://" + hostname + ":" + 8081 + "/api/products";
        //A rest template is used to make a GET request to the REST API. The response is made into a list of products that is passed as an attribute to the model.
        RestTemplate restTemplate = new RestTemplate(); 
        ResponseEntity<List<ProductModel>> productsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductModel>>() {});
        List<ProductModel> products = productsResponse.getBody(); 
        model.addAttribute("openingText", "Products");
        model.addAttribute("products", products);
        return "products";
    }
    
    
    /** 
     * Searches for a specific product
     * @param product The product that is being searched up in the search bar
     * @param model The model to be viewed by the page
     * @return The product page with the results of the search
     */
    @GetMapping("/search/{product}")
    public String getProducts(@PathVariable("product") String product, Model model){
        //Gets the application to be used (the REST API service)
        Application application = eurekaClient.getApplication("product-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        //Gets information from the application and creates a URL from it
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        System.out.println(port);
        String url = "http://" + hostname + ":" + 8081 + "/api/products/" + product;
        //A rest template is used to make a GET request to the REST API. The response is made into a list of products that is passed as an attribute to the model.
        RestTemplate restTemplate = new RestTemplate(); 
        ResponseEntity<List<ProductModel>> productsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductModel>>() {});
        List<ProductModel> products = productsResponse.getBody(); 

        model.addAttribute("openingText", "Results for " + product);
        model.addAttribute("products", products);
        return "products";
    }

/**
 * Displays the form for making a product
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
 * A post method that sends a new product to the server to be made
 * @param product A product model, used to get the properties of the product that was made in the product form
 * @param bindResult Used to check if the product had any errors when being made
 * @param model The model being used, which uses the business layer to send the products over the products page for display
 * @return If their was validation issues, it sends you back to the product form, otherwise it will send you to the products page
 */
    @RequestMapping(path="/createProduct", method={RequestMethod.GET, RequestMethod.POST})
    public String createProduct(@Valid ProductModel product, BindingResult bindResult, Model model){
        //Checks for errors in the form, i.e. missing fields, non numerical values in the price, etc.
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

    
    /** 
     * Displays the editing page
     * @param id The id of the product being edited
     * @param model The model to be viewed by the page
     * @return String
     */
    @GetMapping("/edit/{id}/")
    public String editProduct(@PathVariable("id") Long id, Model model){
        //Finds the product by it's ID and passes the product into the view layer
        ProductModel productModel = service.findById(id);
        model.addAttribute("productModel", productModel);
        return "updateform";
    } 

    
    /** 
     * A post method that will update a product in the database
     * @param id
     * @param productModel
     * @param result
     * @param model The model to be viewed by the page
     * @return String
     */
    @RequestMapping(path="/edit/{id}/updating", method = {RequestMethod.GET, RequestMethod.PUT})
    public String changeProduct(@PathVariable("id") Long id, ProductModel productModel, BindingResult result, Model model) {
        System.out.print(productModel.getProductName());
        productModel.setProductId(id);
        //Checks if the product submitted has any errors
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
        //Calls in the delete mapping and redirects to the products page
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
        //Calls in the delete product from the service and redirects to the products page
        service.deleteProduct(id);
        return "redirect:/products/";
    }
}
