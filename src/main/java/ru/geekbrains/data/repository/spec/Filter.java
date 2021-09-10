package ru.geekbrains.data.repository.spec;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class Filter {

    @NotNull
    private int min;
    @NotNull
    private int max;
    @NotNull
    private Command c;
}
