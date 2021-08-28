package ru.geekbrains.spring.filter.annotation;


import ru.geekbrains.spring.filter.validation.FieldNameValidation;
import ru.geekbrains.spring.filter.validation.OperationValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = OperationValidation.class)
@Documented
public @interface Operation {

    String message() default "Operation is wrong";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
