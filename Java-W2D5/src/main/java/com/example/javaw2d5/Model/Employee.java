package com.example.javaw2d5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Employee {

    @NotNull (message = "Id can't be null")
    @Min(value = 3,message = "Id length must be more than 2")
    private Integer id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 5 , message = "Name length must be more than 4")
    private String name;

    @NotNull(message = "Age can't be null")
    @Range(min = 26 , message = "Age must be more than 25")
    private Integer age;

    @AssertFalse(message = "must be false")
    private Boolean onLeave;

    @NotNull(message = "Employment year can't be null")
    @Range(min = 2000 , max = 2022 , message ="Employment year must be a valid year")
    private Integer employmentYear;

    @NotNull(message = "Annual leave can't be null")
    private Integer annualLeave;
}
