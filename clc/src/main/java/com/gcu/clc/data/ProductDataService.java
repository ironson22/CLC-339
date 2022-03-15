package com.gcu.clc.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
}
