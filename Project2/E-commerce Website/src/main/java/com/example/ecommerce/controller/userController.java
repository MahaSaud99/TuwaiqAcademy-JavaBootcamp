package com.example.ecommerce.controller;

import com.example.ecommerce.ApiResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class userController {

    private userService userService;

    public userController(userService userService){
        this.userService=userService;
    }

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        ArrayList<User> users= userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody String id){
        boolean isDeleted=userService.deleteUser(id);

        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong user Id!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id , @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        boolean isUpdated = userService.updateUser(id, user);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("User updated successfully!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong user Id!"));
    }

    @PutMapping("/addStock/{productId}/{merchantId}/{stock}")
    public ResponseEntity addStock(@PathVariable String productId, @PathVariable String merchantId , @PathVariable Integer stock){
        Integer isValid=userService.addStock(productId,merchantId,stock);

        if (isValid==-1){
            return ResponseEntity.status(400).body(new ApiResponse("Stock must be positive number!"));
        } else if (isValid==0){
            return ResponseEntity.status(200).body(new ApiResponse("Stock added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong merchantId or productId"));
    }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable String userId, @PathVariable String productId, @PathVariable String merchantId){
        Integer isValid=userService.buyProduct(userId,productId,merchantId);

        switch (isValid){
            case -1:
                return ResponseEntity.status(400).body(new ApiResponse("Wrong user Id"));

            case 1:
                return ResponseEntity.status(400).body(new ApiResponse("Wrong merchantId or productId"));

            case -2:
                return ResponseEntity.status(400).body(new ApiResponse("The merchant have not the product in stock"));

            case -3:
                return ResponseEntity.status(400).body(new ApiResponse("The balance is less than the product price"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("User purchased successfully"));
    }

}
