package com.gcu.clc.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.clc.model.ProductModel;
 
public class ProductBusinessService {
    public List<ProductModel> getProducts(){
        //Need to attempt to keep Description similar length to prevent card for Product from resizing bigger than the other due to word wrap
        List<ProductModel> products = new ArrayList<ProductModel>();
        products.add(new ProductModel(0, "Samsung 65\" TV", "Samsung's 65\" TV, LED lighting, 2021 Model", "/assets/images/samsung_65_tv.jpg", 670.99f));
        products.add(new ProductModel(0, "IPhone XS, 512 GB, Silver", "A Silver IPhone XS with 512 GBs of storage.", "/assets/images/Iphone_XS_Silver.jpg", 429.99f));
        //Please find a picture of the keyboard with out a black backfround or run through background remover(Prefer white background)
        products.add(new ProductModel(0, "LED Gaming Keyboard/Mouse", "An keyboard/mouse with RGB backlights", "/assets/images/Rainbow_Keyboard_And_Mouse.jpg", 19.99f));
        products.add(new ProductModel(0, "Samsung 65\" TV", "Samsung's 65\" TV, LED lighting, 2021 Model", "/assets/images/samsung_65_tv.jpg", 670.99f));

        //Need to add two addition product for the products page to look complete
        products.add(new ProductModel(0, "Samsung 60\" TV", "Samsung's 65\" TV, LED lighting, 2019 Model", "/assets/images/samsung_65_tv.jpg", 668.99f));
        products.add(new ProductModel(0, "Samsung 70\" TV", "Samsung's 65\" TV, LED lighting, 2020 Model", "/assets/images/samsung_65_tv.jpg", 669.99f));

        return products;
    }
}
