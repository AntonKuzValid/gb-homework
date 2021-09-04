package ru.geekbrains.data.repository.spec;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Filter {

    @NotNull
    private int min;
    @NotNull
    private int max;
    @NotNull
    private Command c;
}
