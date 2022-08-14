package com.example.ecommerce.controller;

import com.example.ecommerce.ApiResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.categoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class categoryController {

    private categoryService categoryService;

    public categoryController(categoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/get")
    public ResponseEntity getCategories(){
        ArrayList<Category> categories= categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category added successfully!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody String id){
    boolean isDeleted=categoryService.deleteCategory(id);

        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Category deleted successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong category Id!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id , @RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isUpdated = categoryService.updateCategory(id, category);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Category updated successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong category Id!"));
    }


    }


