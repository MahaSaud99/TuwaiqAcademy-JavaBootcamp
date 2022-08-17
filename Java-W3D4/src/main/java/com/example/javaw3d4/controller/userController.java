package com.example.javaw3d4.controller;


import com.example.javaw3d4.dto.apiResponse;
import com.example.javaw3d4.dto.loginForm;
import com.example.javaw3d4.model.User;
import com.example.javaw3d4.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class userController {

    private userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List> getUsers(){
        List<User> users=userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity<apiResponse> addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body(new apiResponse("User Added Successfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<apiResponse> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new apiResponse("User Deleted Successfully!"));
    }

    @GetMapping("/byId")
    public ResponseEntity<User> getUserByID(@RequestBody String id){
        User user= userService.getUserByID(id);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<User> getUserByEmail(@RequestBody String email){
        User user= userService.getUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/byAge")
    public ResponseEntity<List> getUsersByAge(@RequestBody Integer age){
        List<User> users= userService.getUsersByAge(age);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/byRole")
    public ResponseEntity<Integer> countUsersByRole(@RequestBody String role){
        Integer users= userService.countUsersByRole(role);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/checkUser")
    public ResponseEntity<apiResponse> checkUser(@RequestBody @Valid loginForm user){
        userService.checkUser(user);
        return ResponseEntity.status(200).body(new apiResponse("Correct username and password"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<apiResponse> updateUser(@RequestBody @Valid User user, @PathVariable String id){
        userService.updateUser(user,id);
        return ResponseEntity.status(200).body(new apiResponse("User Updated Successfully!"));
    }

    @PutMapping("/UpdatePass/{id}")
    public ResponseEntity<apiResponse> updatePass(@PathVariable String id ,@RequestBody String newPass){
        userService.updatePass(id,newPass);
        return ResponseEntity.status(200).body(new apiResponse("Password Updated Successfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse> checkJoiningYear(@PathVariable String id ,@RequestBody LocalDate joiningYear){
        userService.checkJoiningYear(id,joiningYear);
        return ResponseEntity.status(200).body(new apiResponse("User joined with the same date "));
    }

    @GetMapping("/byJoiningYear")
    public ResponseEntity<List> getUser(@RequestBody LocalDate joiningYear){
      List<User> users=userService.getUsersByJoiningYear(joiningYear);
      return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/byJoiningYearAndAge/{age}")
    public ResponseEntity<List> getUsersByJoiningYearAndAge(@RequestBody LocalDate joiningYear,@PathVariable Integer age){
        List<User> users=userService.getUsersByJoiningYearAndAge(joiningYear,age);
        return ResponseEntity.status(200).body(users);
    }





}

