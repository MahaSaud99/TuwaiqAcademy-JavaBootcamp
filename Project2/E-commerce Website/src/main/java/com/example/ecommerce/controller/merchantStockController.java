package com.example.ecommerce.controller;

import com.example.ecommerce.ApiResponse;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.merchantStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStock")
public class merchantStockController{

    private merchantStockService merchantStockService;

    public merchantStockController(merchantStockService merchantStockService){
        this.merchantStockService=merchantStockService;
    }

    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStock> merchantStocks= merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isAdded=merchantStockService.addMerchantStock(merchantStock);
        if (isAdded){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock added successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Product Id or Merchant Id not found!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchantStock(@RequestBody String id){
        boolean isDeleted=merchantStockService.deleteMerchantStock(id);

        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock deleted successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong MerchantStock Id!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id , @RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock updated successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong MerchantStock Id or Product Id or Merchant Id!"));
    }



}
