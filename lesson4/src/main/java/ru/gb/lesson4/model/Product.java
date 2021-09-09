package ru.gb.lesson4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
 import java.math.BigDecimal;

@Data

public class Product {

    private Integer id;
    @NotNull
    @JsonProperty("title")
    private String title;
    @JsonFormat()
    private BigDecimal price;

}
