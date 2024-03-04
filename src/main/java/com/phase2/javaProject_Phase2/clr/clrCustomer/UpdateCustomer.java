package com.phase2.javaProject_Phase2.clr.clrCustomer;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
@Order(7)
public class UpdateCustomer implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Customer> updateCustomer = customerRepository.findById(1);
        System.out.println("Customer to update: ");
        updateCustomer.ifPresent(System.out::println);
        System.out.println();
        updateCustomer.ifPresent((customer -> {
            customer.setFirst_Name("SHANI");
            customerRepository.saveAndFlush(customer);
            System.out.println("Customer is updated!");
            System.out.println();
        }));
    }
}
