package com.example.javaw2d4hw.controller;

import com.example.javaw2d4hw.ApiResponse;
import com.example.javaw2d4hw.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class taskController{

    ArrayList<Task> tasks= new ArrayList<>();


    @GetMapping("/tasks")
    public ArrayList<Task> getCustomers(){
        return tasks;
    }

    @PostMapping("/tasks")
    public ApiResponse addCustomer(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("Task added to the list");
    }

    @DeleteMapping("/tasks/{index}")
    public ApiResponse delete(@PathVariable Integer index){
        tasks.remove(index);
        return new ApiResponse("Task deleted from the list");
    }

    @PutMapping("/tasks/{index}")
    public ApiResponse update(@PathVariable Integer index , @RequestBody Task task ){
        tasks.set(index,task);
        return new ApiResponse("Task updated");
    }


    @PutMapping("/tasks/status/{index}")
    public ApiResponse status(@PathVariable Integer index , @RequestBody String status ){
        tasks.get(index).setStatus(status);
        return new ApiResponse("Status updated");
    }

    @GetMapping("/tasks/search")
    public ApiResponse search(@RequestBody String title){
        for (Integer i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitle().equals(title)){
                return new ApiResponse(tasks.get(i).toString());
            }
        }
        return new ApiResponse("Task not found!");
    }

}
