package com.gcu.clc.business;
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
    public List<ProductModel> searchProductsByName(String productName){
        return service.findProductsByName(productName);
    }
    public boolean createProduct(ProductModel productModel){
        return service.createProduct(productModel);
    }
    
    //find a product by id
    public ProductModel findById(Long id){
        return service.findById(id);
    }

    public boolean updateProduct(ProductModel productModel){
        return service.updateProduct(productModel);
    }

    //delete a product by id
    public boolean deleteProduct(Long id){
        return service.deleteProduct(id);
    }
    
    public void init(){
        System.out.println("Initializing products");
    }
    
    public void destroy(){
        System.out.println("Destroying products");
    }

}
