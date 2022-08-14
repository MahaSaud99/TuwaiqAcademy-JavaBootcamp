package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Category {

    @NotEmpty(message = "Id must not be empty!")
    @Size(min = 3, message = "Id have to be 3 character long")
    private String id;

    @NotEmpty (message = "Name must not be empty!")
    @Size(min = 3, message = "Name have to be 3 character long")
    private String name;
}
