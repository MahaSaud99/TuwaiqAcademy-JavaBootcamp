package com.example.grades.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GradeController {
    ArrayList<String> grades= new ArrayList<>();


    @GetMapping("/grade")
    public ArrayList<String> getGrades(){
        return grades;
    }

    @PostMapping("/grade")
    public String addgGrade(@RequestBody String grade){
        grades.add(grade);
        return "Grade added to the list";
    }

    @PutMapping("/grade/{index}")
    public String update(@PathVariable int index , @RequestBody String grade){
        grades.set(index,grade);
        return "Grade updated";
    }

    @DeleteMapping("/grade/{index}")
    public String delete(@PathVariable int index){
        grades.remove(index);
        return "Grade deleted from the list";
    }
}
