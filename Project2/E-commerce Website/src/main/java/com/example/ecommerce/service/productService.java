package com.example.ecommerce.service;

import com.example.ecommerce.controller.categoryController;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class productService {
    ArrayList<Product> products=new ArrayList<>();
    private categoryService categoryService;

    public productService(categoryService categoryService){
        this.categoryService=categoryService;
    }

    public ArrayList<Product> getProductList() {
        return products;
    }

    public boolean addProduct(Product product) {
        ArrayList<Category> categories= categoryService.getCategories();

        for (int i = 0; i < categories.size() ; i++) {
            if (categories.get(i).getId().equals(product.getCategoryID())){
                products.add(product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateProduct(String id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }
}
