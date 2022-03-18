package com.gcu.clc.controller;

import java.util.List;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class RestApiController {
    @Autowired
    ProductBusinessService service;
    // @GetMapping("/")
    // public ResponseEntity<?> findProducts(){
    //     List<ProductModel> products = service.getProducts();
    //     return new ResponseEntity<>(products, HttpStatus.OK);
    // }
    @PutMapping("/edit")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel product){
        System.out.println("In update Product PUT");
        System.out.print(product.getProductName());
        System.out.println(product.getProductName());
        if(service.updateProduct(product)){
            System.out.println("In update Product PUT");
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }else{
            System.out.println("Not in update Product PUT");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
