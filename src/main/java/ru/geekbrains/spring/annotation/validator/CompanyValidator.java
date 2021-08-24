package ru.geekbrains.spring.annotation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring.annotation.Company;
import ru.geekbrains.spring.repository.impl.CompanyRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Кастомный валидатор Company
 */
public class CompanyValidator implements ConstraintValidator<Company, String> {

    @Autowired
    private CompanyRepository repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return repository.getAll().contains(value);
    }
}
