package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchantStockService {
    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();
    private productService productService;
    private merchantService merchantService;

    public merchantStockService(productService productService, merchantService merchantService) {
        this.productService = productService;
        this.merchantService = merchantService;
    }

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocks;
    }

    public boolean addMerchantStock(MerchantStock merchantStock) {
        ArrayList<Product> products = productService.getProductList();
        ArrayList<Merchant> merchants = merchantService.getMerchants();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(merchantStock.getProductId())) {

                for (int j = 0; j < merchants.size(); j++) {
                    if (merchants.get(i).getId().equals(merchantStock.getMerchantId())) {
                        merchantStocks.add(merchantStock);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateMerchantStock(String id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {

            if (merchantStocks.get(i).getId().equals(id)){
                ArrayList<Product> products = productService.getProductList();
                ArrayList<Merchant> merchants = merchantService.getMerchants();

                for (int l = 0; l < products.size(); l++) {
                    if (products.get(l).getId().equals(merchantStock.getProductId())) {

                        for (int j = 0; j < merchants.size(); j++) {
                            if (merchants.get(j).getId().equals(merchantStock.getMerchantId())) {
                                merchantStocks.set(i,merchantStock);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

