package com.example.spring_boot.annotation.validator;

import com.example.spring_boot.annotation.Company;
import com.example.spring_boot.repository.CompanyRepository;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

@RequiredArgsConstructor
public class CompanyValidator implements ConstraintValidator<Company, String>, Annotation {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public void initialize(Company constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext context) {
        System.out.println("isValid - " + companyName);
        return companyRepository.isCompany(companyName);
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
