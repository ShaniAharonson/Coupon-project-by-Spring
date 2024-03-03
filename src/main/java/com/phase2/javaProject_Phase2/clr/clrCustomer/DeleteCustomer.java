package com.phase2.javaProject_Phase2.clr.clrCustomer;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(8)
public class DeleteCustomer implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Customer> customerToDelete = customerRepository.findById(3);
        customerToDelete.ifPresent((customer -> {
            customer.setCoupons(null);
            customerRepository.saveAndFlush(customer);
            customerRepository.deleteById(3);
            System.out.println("Customer deleted!");
            System.out.println();
        }));
    }
}
