package ru.geekbrains.spring.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ru.geekbrains.spring.filter.annotation.FieldName;
import ru.geekbrains.spring.filter.annotation.Operation;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Validated
public class Filter {

    @NotNull
    @FieldName
    private String fieldName;
    @NotNull
    @Operation
    private String operation;
    @NotNull
    private String value;
}
