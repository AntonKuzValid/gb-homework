package ru.geekbrains.spring.filter.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring.filter.annotation.FieldName;
import ru.geekbrains.spring.repository.database.DatabaseAccess;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldNameValidation implements ConstraintValidator<FieldName, String> {

    @Autowired
    private DatabaseAccess databaseAccess;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return databaseAccess.getColumnNames().contains(s);
    }

}
