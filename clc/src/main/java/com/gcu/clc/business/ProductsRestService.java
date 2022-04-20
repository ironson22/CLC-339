package com.gcu.clc.business;

import java.util.List;

import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
    @Autowired ProductBusinessService service;

    
    /** 
     * @return List<ProductModel>
     */
    @GetMapping(path="/products/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getProductsAsJson(){
        return service.getProducts();
    }
}
