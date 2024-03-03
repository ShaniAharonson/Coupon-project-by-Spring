package com.phase2.javaProject_Phase2.clr.clrCustomer;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class CustomerSmartDialect implements CommandLineRunner{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Boolean existsByEmailAndPassword = customerRepository.existsByEmailAndPassword
                ("Shani@shani.com","1234");
        System.out.println("Customer exists? -> "+ existsByEmailAndPassword);
    }
}
