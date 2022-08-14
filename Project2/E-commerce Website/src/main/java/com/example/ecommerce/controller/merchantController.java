package com.example.ecommerce.controller;

import com.example.ecommerce.ApiResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.service.merchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
public class merchantController {

    private merchantService merchantService;

    public merchantController(merchantService merchantService){
        this.merchantService=merchantService;
    }

    @GetMapping("/get")
    public ResponseEntity getMerchants(){
        ArrayList<Merchant> merchants= merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant added successfully!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchant(@RequestBody String id){
        boolean isDeleted=merchantService.deleteMerchant(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant deleted successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant Id!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id , @RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isUpdated = merchantService.updateMerchant(id,merchant);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant updated successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant Id!"));
    }
}
