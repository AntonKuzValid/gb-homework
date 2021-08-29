package com.example.spring_boot.repository;

import com.example.spring_boot.model.ProducerCompany;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class CompanyRepository {

    private final List<ProducerCompany> companyList = new CopyOnWriteArrayList<>();

    public CompanyRepository(){
        ProducerCompany company1 = new ProducerCompany();
        company1.setCompanyName("Africa fruits");
        save(company1);

        ProducerCompany company2 = new ProducerCompany();
        company2.setCompanyName("Fruits and Co");
        save(company2);

        ProducerCompany company3 = new ProducerCompany();
        company3.setCompanyName("Turkey Fruits Company");
        save(company3);

        ProducerCompany company4 = new ProducerCompany();
        company4.setCompanyName("Thai plants");
        save(company4);

        ProducerCompany company5 = new ProducerCompany();
        company5.setCompanyName("Azerbaijan export");
        save(company5);
    }

    public void save(ProducerCompany company){
        companyList.add(company);
    }

    public boolean isCompany(String company){
        ProducerCompany producerCompany = new ProducerCompany();
        producerCompany.setCompanyName(company);

        return companyList.contains(producerCompany);
    }
}
