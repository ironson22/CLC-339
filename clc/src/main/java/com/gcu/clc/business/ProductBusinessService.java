package com.gcu.clc.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
 
public class ProductBusinessService {
    @Autowired
    private ProductDataService service;

    public List<ProductModel> getProducts(){
        
        return service.findProducts();
    }

    // public static void addProduct(ProductModel product){
    //     products.add(product);
    // }
}
