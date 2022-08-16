package com.example.schoolms.controller;

import com.example.schoolms.dto.apiResponse;
import com.example.schoolms.model.Student;
import com.example.schoolms.service.studentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {

   studentService studentService;

   public studentController(studentService studentService){
      this.studentService=studentService;
   }

   @GetMapping
   public ResponseEntity getStudents(){
      List<Student> students= studentService.getStudents();
      return ResponseEntity.status(200).body(students);
   }

   @PostMapping
   public ResponseEntity addStudent(@RequestBody @Valid Student student){
      studentService.addStudent(student);
      return ResponseEntity.status(200).body(new apiResponse("Student added successfully!"));
   }

   @DeleteMapping
   public ResponseEntity deleteStudent(@RequestBody String id){
     studentService.deleteStudent(id);
         return ResponseEntity.status(200).body(new apiResponse("Student deleted successfully!"));
   }

   @PutMapping("/{id}")
   public ResponseEntity updateStudent(@PathVariable String id , @RequestBody @Valid Student student) {
       studentService.updateStudent(id, student);
       return ResponseEntity.status(200).body(new apiResponse("Student updated successfully!"));
   }

   @GetMapping("/byId")
   public ResponseEntity<Student> getStudentByID(@RequestBody String id){
      Student student= studentService.getStudentByID(id);
      return ResponseEntity.status(200).body(student);
   }

   @GetMapping("/byName")
   public ResponseEntity<Student> getStudentByName(@RequestBody String name){
      Student student= studentService.getStudentByName(name);
      return ResponseEntity.status(200).body(student);
   }

   @GetMapping("/byMajor")
   public ResponseEntity<List> getStudentsByMajor(@RequestBody String major){
      List<Student> students= studentService.getStudentsByMajor(major);
      return ResponseEntity.status(200).body(students);
   }

   @GetMapping("/byAge")
   public ResponseEntity<List> getStudentsByAge(@RequestBody Integer age){
      List<Student> students= studentService.getStudentsByAge(age);
      return ResponseEntity.status(200).body(students);
   }


}
