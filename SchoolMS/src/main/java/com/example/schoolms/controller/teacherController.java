package com.example.schoolms.controller;

import com.example.schoolms.dto.apiResponse;
import com.example.schoolms.model.Teacher;
import com.example.schoolms.service.teacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class teacherController {

    teacherService teacherService;

    public teacherController(teacherService teacherService){
        this.teacherService=teacherService;
    }

    @GetMapping
    public ResponseEntity getTeachers(){
        List<Teacher> teachers= teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new apiResponse("Teacher added successfully!"));
    }

    @DeleteMapping
    public ResponseEntity deleteTeacher(@RequestBody String id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new apiResponse("Teacher deleted successfully!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id , @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new apiResponse("Teacher updated successfully!"));
    }

    @GetMapping("/byId")
    public ResponseEntity<Teacher> getTeacherByID(@RequestBody String id){
        Teacher teacher= teacherService.getTeacherByID(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/bySalary")
    public ResponseEntity<List> getTeachersBySalary(@RequestBody Integer salary){
        List<Teacher> teachers= teacherService.getTeachersBySalary(salary);
        return ResponseEntity.status(200).body(teachers);
    }


}
