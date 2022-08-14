package com.example.ecommerce.service;

import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userService {
    ArrayList<User> users=new ArrayList<>();
    merchantStockService merchantStockService;
    productService productService;

    public userService(merchantStockService merchantStockService , productService productService){
        this.merchantStockService=merchantStockService;
        this.productService=productService;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean deleteUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public Integer addStock(String productId, String merchantId, Integer stock) {
        if (stock<=0){
            return -1;
        }

        ArrayList<MerchantStock> merchantStocks=merchantStockService.getMerchantStock();
        for (int i = 0; i < merchantStocks.size(); i++) {
            MerchantStock merchantStock=merchantStocks.get(i);
            if (merchantStock.getMerchantId().equals(merchantId)&&merchantStock.getProductId().equals(productId)){
                merchantStock.setStock(merchantStock.getStock()+stock);
                return 0;
            }
        }
        return 1;
    }

    public Integer buyProduct(String userId, String productId, String merchantId) {

        //Check if the userId is valid
        for (int i = 0; i < users.size() ; i++) {
            User user=users.get(i);
            if (user.getId().equals(userId)){

                //Check if product id & merchant id are valid
                ArrayList<MerchantStock> merchantStocks=merchantStockService.getMerchantStock();
                for (int j = 0; j < merchantStocks.size() ; j++) {
                    MerchantStock merchantStock = merchantStocks.get(j);
                    if (merchantStock.getMerchantId().equals(merchantId) && merchantStock.getProductId().equals(productId)) {

                        // Check the stock
                        if (merchantStock.getStock() == 0) {
                            return -2; //bad request
                        }

                        // Get product price
                        ArrayList<Product> products = productService.getProductList();
                        Integer price = 0;
                        for (int k = 0; k < products.size(); k++) {
                            if (products.get(k).getId().equals(productId)) {
                                price = products.get(k).getPrice();
                            }
                        }

                        //Check the balance
                        if (user.getBalance() < price) {
                            return -3;
                        }

                        //deducted the price && reduce the stock
                        merchantStock.setStock(merchantStock.getStock() - 1);
                        user.setBalance(user.getBalance() - price);
                        return 0;// user buy successfully
                    }
                }
                return 1; // wrong product id or merchant id
            }
        }
        return -1;//user not valid
    }
}
