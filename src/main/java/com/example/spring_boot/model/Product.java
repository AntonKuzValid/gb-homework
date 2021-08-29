package com.example.spring_boot.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Product {

    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String title;

    @NotEmpty(message = "Company should not be empty")
    private String company;

    @Min(value = 0, message = "Price should be greater then 0")
    private Integer cost;
}
