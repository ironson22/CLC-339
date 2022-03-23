package com.gcu.clc.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
@Service
public class ProductDataService {
    @Autowired
    DataSource datasource;
    private JdbcTemplate jdbcTemplateObject;

    public ProductDataService(DataSource datasource){
        this.datasource = datasource;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
    }

    public List<ProductModel> findProductsByName(String productName){
        String sql = "SELECT * FROM products WHERE product_name LIKE '%" + productName + "%'";
        List<ProductModel> products = new ArrayList<ProductModel>();

        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            while(rowSet.next()){
                products.add(new ProductModel(rowSet.getLong("product_id"), rowSet.getString("product_name"), rowSet.getString("description"), rowSet.getString("category"), rowSet.getFloat("price")));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return products;
    }
    public List<ProductModel> findProducts(){
        String sql = "SELECT * FROM products";
        List<ProductModel> products = new ArrayList<ProductModel>();
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            while(rowSet.next()){
                products.add(new ProductModel(rowSet.getLong("product_id"), rowSet.getString("product_name"), rowSet.getString("description"), rowSet.getString("category"), rowSet.getFloat("price")));
            }
            return products;
        }catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }
    /**
     * find a product by id
     * @param id
     * @return
     */
    public ProductModel findById(Long id){
        String sql = "SELECT * FROM products WHERE product_id = ?";
        ProductModel product = new ProductModel();
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql, id);
            while(rowSet.next()){
                product = new ProductModel(rowSet.getLong("product_id"), rowSet.getString("product_name"), rowSet.getString("description"), rowSet.getString("category"), rowSet.getFloat("price"));
            }
            return product;
        }catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public boolean createProduct(ProductModel product){
        String sql = "INSERT INTO products(product_name, description, price, category) VALUES (?, ?, ?, ?)";
        try{
            int rows = jdbcTemplateObject.update(sql, product.getProductName(), product.getDescription(), product.getPrice(), product.getCategory());
            if(rows == 1){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    /**
     * Deletes a product from the database
     * @param id
     * @return
     */
    public boolean deleteProduct(Long id){
        String sql = "DELETE FROM products WHERE product_id = ?";
        try{
            int rows = jdbcTemplateObject.update(sql, id);
            if(rows == 1){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates a product in the database
     * @param product
     * @return
     */
    public boolean updateProduct(ProductModel product){
        String sql = "UPDATE products SET product_name = ?, description = ?, price = ?, category = ? WHERE product_id = ?";
        try{
            int rows = jdbcTemplateObject.update(sql, product.getProductName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getProductId());
            if(rows == 1){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
