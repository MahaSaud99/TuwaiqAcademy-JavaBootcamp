package com.example.javaw2d4hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {
    private Integer id;
    private String title;
    private String description;
    private String status;
}
