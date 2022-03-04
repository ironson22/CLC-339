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

    public List<ProductModel> findProducts(){
        String sql = "SELECT * FROM products";
        List<ProductModel> products = new ArrayList<ProductModel>();
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            while(rowSet.next()){
                products.add(new ProductModel(rowSet.getString("product_name"), rowSet.getString("description"), rowSet.getString("category"), rowSet.getFloat("price")));
            }
            return products;
        }catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }
}