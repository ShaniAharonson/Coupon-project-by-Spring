package com.phase2.javaProject_Phase2.clr.clrCompany;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(3)
public class DeleteCompany implements CommandLineRunner {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Company> companyToDelete = companyRepository.findById(3);
        companyToDelete.ifPresent((company ->{
            // remove relations by keeps coupons
            company.setCoupons(null);
            companyRepository.deleteById(3);
            System.out.println("Company deleted!");
            System.out.println();
        }));
    }
}
