package com.phase2.javaProject_Phase2.clr.clrCustomer;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Order(9)
public class GetAllCustomers implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Customer> allCustomers =customerRepository.findAll();
        System.out.println("All Customers:");
        allCustomers.forEach(System.out::println);
        System.out.println();
    }
}
