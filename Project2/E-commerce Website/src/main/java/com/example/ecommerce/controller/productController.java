package com.example.ecommerce.controller;

import com.example.ecommerce.ApiResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.productService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product/")
public class productController {

    private productService productService;
    productController(productService productService){
        this.productService=productService;
    }

    @GetMapping("/get")
    public ResponseEntity getProducts(){
        ArrayList<Product> products= productService.getProductList();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isAdded=productService.addProduct(product);
        if (isAdded){
            return ResponseEntity.status(200).body(new ApiResponse("Product added successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Category not found!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestBody String id){
        boolean isDeleted=productService.deleteProduct(id);

        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Product deleted successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong product Id!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id , @RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isUpdated = productService.updateProduct(id, product);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Product updated successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong product Id!"));
    }

}
