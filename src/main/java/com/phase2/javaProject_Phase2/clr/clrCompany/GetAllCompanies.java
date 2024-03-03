package com.phase2.javaProject_Phase2.clr.clrCompany;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(4)
public class GetAllCompanies implements CommandLineRunner {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Company> allCompanies = companyRepository.findAll();
        System.out.println("All companies:");
        allCompanies.forEach(System.out::println);
        System.out.println();
    }
}
