package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(5)
@RequiredArgsConstructor
public class testing implements CommandLineRunner {
    private final CustomerService customerService;


    @Override
    public void run(String... args) throws Exception {
        //System.out.println(customerService.getAllCustomerCouponsByCategory(Category.ELECTRICITY));
    }
}
