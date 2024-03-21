package com.phase2.javaProject_Phase2.clr.clrCompany;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(5)
public class CompanySmartDialect implements CommandLineRunner {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {
        Boolean existsByEmailAndPassword = companyRepository.existsByEmailAndPassword("Microsoft@microsoft.com","101010");
        System.out.println("Company exists? -> "+ existsByEmailAndPassword);
        System.out.println();
    }
}
