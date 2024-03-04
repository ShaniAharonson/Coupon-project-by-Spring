package com.phase2.javaProject_Phase2.clr.clrCompany;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
@Order(2)
public class UpdateCompany implements CommandLineRunner {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {
        Optional<Company> updateCompany = companyRepository.findById(1);
        System.out.println("Company to update:");
        updateCompany.ifPresent((System.out::println));
        System.out.println();
        updateCompany.ifPresent((company -> {
            company.setName("MICROSOFT");
            companyRepository.saveAndFlush(company);
            System.out.println("Company is updated!");
            System.out.println();
        }));

    }
}
