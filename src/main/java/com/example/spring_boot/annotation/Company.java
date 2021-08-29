package com.example.spring_boot.annotation;

import com.example.spring_boot.annotation.validator.CompanyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = CompanyValidator.class)
public @interface Company {

    String message() default "Company name is wrong";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
