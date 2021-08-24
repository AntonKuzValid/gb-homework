package ru.geekbrains.spring.annotation;

import ru.geekbrains.spring.annotation.validator.CompanyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CompanyValidator.class)
@Documented
public @interface Company {

    String message() default "Company wrong";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
