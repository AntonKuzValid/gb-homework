package ru.geekbrains.spring.filter.validation;

import com.google.common.base.Enums;
import ru.geekbrains.spring.filter.annotation.Operation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class OperationValidation implements ConstraintValidator<Operation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Enums.getIfPresent(ru.geekbrains.spring.command.Operation.class, s).orNull() != null;
    }
}
