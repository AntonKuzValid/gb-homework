package com.example.spring_boot.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Product {

    private Integer id;

    @NotNull
    private String title;

    private String company;

    private Integer cost;
}
