package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Product {

    @NotEmpty (message = "Id must not be empty!")
    @Size(min = 3, message = "Id have to be 3 character long")
    private String id;

    @NotEmpty (message = "Name must not be empty!")
    @Size(min = 3, message = "Name have to be 3 character long")
    private String name;

    @NotNull(message = "Price must not be empty!")
    @Positive(message = "Price must be positive number")
    private Integer price;

    @NotEmpty (message = "CategoryID must not be empty!")
    @Size(min = 3, message = "CategoryID have to be 3 character long")
    private String CategoryID;
}
