package com.gcu.clc.business;
import java.util.List;
import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
public class ProductBusinessService {
    @Autowired
    private ProductDataService service;

    
    /** 
     * @return List<ProductModel>
     */
    public List<ProductModel> getProducts(){
        
        return service.findProducts();
    }
    
    /** 
     * @param productName
     * @return List<ProductModel>
     */
    public List<ProductModel> searchProductsByName(String productName){
        return service.findProductsByName(productName);
    }
    
    /** 
     * @param productModel
     * @return boolean
     */
    public boolean createProduct(ProductModel productModel){
        return service.createProduct(productModel);
    }
    
    
    /** 
     * @param id
     * @return ProductModel
     */
    //find a product by id
    public ProductModel findById(Long id){
        return service.findById(id);
    }

    
    /** 
     * @param productModel
     * @return boolean
     */
    public boolean updateProduct(ProductModel productModel){
        return service.updateProduct(productModel);
    }

    
    /** 
     * @param id
     * @return boolean
     */
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
