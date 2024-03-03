package com.phase2.javaProject_Phase2.clr.clrCompany;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(1)
public class CreateCompany implements CommandLineRunner {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- COMPANIES -------------");
        // add company
        Company company1 = Company.builder()
                .name("Microsoft")
                .email("Microsoft@microsoft.com")
                .password("101010")
                .build();

        Company company2 = Company.builder()
                .name("Apple")
                .email("Apple@apple.com")
                .password("202020")
                .build();

        Company company3 = Company.builder()
                .name("Nvidia")
                .email("Nvidia@nvidia.com")
                .password("303030")
                .build();

        companyRepository.saveAll(Arrays.asList(company1, company2, company3));
        System.out.println("Companies created!");
        System.out.println();

        // update company


        // delete company by id

        // get all companies
    }
}
