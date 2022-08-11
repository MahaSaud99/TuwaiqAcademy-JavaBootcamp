package com.example.javaw2d5.Controller;

import com.example.javaw2d5.ApiResponse;
import com.example.javaw2d5.Model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class employeesController {

        private ArrayList<Employee> employeesList=new ArrayList<>();

        @GetMapping("/employees")
        public ResponseEntity getEmployees(){
            return ResponseEntity.status(200).body(employeesList);
        }

        @PostMapping("/addEmployee")
        public ResponseEntity addEmployees(@RequestBody @Valid Employee employee, Errors errors){
            if(errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message));
            }
            employeesList.add(employee);
            return ResponseEntity.status(201).body(new ApiResponse("New employee added !"));
        }

        @PutMapping("/update/{index}")
        public ResponseEntity updateEmployee(@PathVariable Integer index , @RequestBody @Valid Employee employee , Errors errors){
            if (errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message));
            }

            if (index<employeesList.size()){
                employeesList.set(index,employee);
                return ResponseEntity.status(201).body(new ApiResponse("Employee updated"));
            }

            return ResponseEntity.status(400).body("Wrong index");
        }

        @DeleteMapping("/delete/{index}")
        public ResponseEntity deleteEmployee(@PathVariable Integer index){
            if (index<employeesList.size()){
                employeesList.remove((int)index);
                return ResponseEntity.status(201).body(new ApiResponse("Employee deleted from the list"));
            }
            return ResponseEntity.status(400).body("Wrong index");
        }


    @PutMapping("/annualLeave")
    public ResponseEntity applyForAnnualLeave(@RequestBody Integer id){


        for (int i = 0; i < employeesList.size(); i++) {
            Employee employee=employeesList.get(i);
            if (employee.getId().equals(id)){
                if(employee.getOnLeave()==true||employee.getAnnualLeave()==0){
                    return ResponseEntity.status(400).body(new ApiResponse("bad request"));
                }

                employee.setOnLeave(true);
                employee.setAnnualLeave(employee.getAnnualLeave()-1);
                return ResponseEntity.status(201).body(new ApiResponse("Employee apply successfully"));
            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong ID , employee not found!"));
    }


    }
