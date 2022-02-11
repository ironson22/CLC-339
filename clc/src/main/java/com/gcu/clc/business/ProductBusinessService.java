package com.gcu.clc.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.clc.model.ProductModel;
 
public class ProductBusinessService {
    public List<ProductModel> getProducts(){
        List<ProductModel> products = new ArrayList<ProductModel>();
        products.add(new ProductModel(0, "Samsung 65\" TV", "Samsung's 65\" TV, LED lighting, 2021 Model", "/assets/images/samsung_65_tv.jpg", 670.99f));
        products.add(new ProductModel(0, "IPhone XS, 512 GB, Silver", "A Silver IPhone XS with 512 GBs of storage.", "/assets/images/Iphone_XS_Silver.jpg", 429.99f));
        products.add(new ProductModel(0, "Rainbow Gaming Keyboard And Mouse", "An affordable keyboard and mouse for gamers, complete with RGB backlights", "/assets/images/Rainbow_Keyboard_And_Mouse.jpg", 19.99f));
        products.add(new ProductModel(0, "Samsung 65\" TV", "Samsung's 65\" TV, LED lighting, 2021 Model", "/assets/images/samsung_65_tv.jpg", 670.99f));

        return products;
    }
}
