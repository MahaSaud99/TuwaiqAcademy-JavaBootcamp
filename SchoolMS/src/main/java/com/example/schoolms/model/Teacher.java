package com.example.schoolms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Teacher {
    @Id
    @NotEmpty(message = "Id should not be empty!")
    @Column(columnDefinition = "varchar(10) not null")
    private String id;
    @NotEmpty(message = "Name should not be empty!")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @NotNull(message = "Salary should not be null!")
    @Column(columnDefinition = "Integer not null")
    private Integer salary;
}
