package com.gcu.clc.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class ProductBusinessService {
    @Autowired
    private ProductDataService service;

    public List<ProductModel> getProducts(){
        
        return service.findProducts();
    }

    public void init(){
        System.out.println("Initializing products");
    }
    
    public void destroy(){
        System.out.println("Destroying products");
    }
    // public static void addProduct(ProductModel product){
    //     products.add(product);
    // }
}
