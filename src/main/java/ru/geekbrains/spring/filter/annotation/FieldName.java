package ru.geekbrains.spring.filter.annotation;

import ru.geekbrains.spring.filter.validation.FieldNameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldNameValidation.class)
@Documented
public @interface FieldName {

    String message() default "FieldName is wrong";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
