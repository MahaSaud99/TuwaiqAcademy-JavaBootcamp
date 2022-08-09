package com.example.Person.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PeopleController {
    ArrayList<String> names= new ArrayList<>();


    @GetMapping("/name")
    public ArrayList<String> getNames(){
        return names;
    }

    @PostMapping("/name")
    public String addName(@RequestBody String name){
        names.add(name);
        return "Name added to the list";
    }

    @PutMapping("/name/{index}")
    public String update(@PathVariable int index , @RequestBody String name){
        names.set(index,name);
        return "Name updated";
    }

    @DeleteMapping("/name/{index}")
    public String delete(@PathVariable int index){
        names.remove(index);
        return "Name deleted from the list";
    }


}
