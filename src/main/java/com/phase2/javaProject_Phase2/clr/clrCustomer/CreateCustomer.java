package com.phase2.javaProject_Phase2.clr.clrCustomer;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(6)
public class CreateCustomer implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        Coupon coupon1 = new Coupon(1,1,"computer","del computer",
                Date.valueOf(LocalDate.of(2023,1,12)),
                Date.valueOf(LocalDate.of(2024,8,8)),100,1500.0,"image");

        Coupon coupon2 = new Coupon(1,2,"Hamburger","Hamburger with chips",
                Date.valueOf(LocalDate.of(2021,7,1)),
                Date.valueOf(LocalDate.of(2025,7,1)),150,45.5,"image2");

        Coupon coupon3 = new Coupon(1,3,"VIVINO restaurant","Family deal meal",
                Date.valueOf(LocalDate.of(2022,9,14)),
                Date.valueOf(LocalDate.of(2026,6,5)),200,250.0,"image3");

        Coupon coupon4 = new Coupon(1,4,"Vacation in Eilat","Best vacation in Dan Eilat hotel",
                Date.valueOf(LocalDate.of(2022,6,20)),
                Date.valueOf(LocalDate.of(2025,8,31)),1000,1500.5,"image4");

        Coupon coupon5 = new Coupon(2,1,"XBOX","have fun in work while playing together",
                Date.valueOf(LocalDate.of(2023,1,13)),
                Date.valueOf(LocalDate.of(2025,4,20)),25,2499.9,"image5");

        Coupon coupon6 = new Coupon(2,2,"Fish","fish & chips",
                Date.valueOf(LocalDate.of(2023,11,22)),
                Date.valueOf(LocalDate.of(2027,12,6)),130,30.0,"image6");

        Coupon coupon7 = new Coupon(2,3,"Benedict","Morning deal",
                Date.valueOf(LocalDate.of(2024,2,2)),
                Date.valueOf(LocalDate.of(2027,5,18)),20,100.0,"image7");

        Coupon coupon8 = new Coupon(2,4,"Vacation in Cineret","Best hotel on Cineret lake",
                Date.valueOf(LocalDate.of(2023,9,1)),
                Date.valueOf(LocalDate.of(2024,9,29)),38,1500.0,"image8");

        System.out.println("------------- CUSTOMERS -------------");
        Customer customer1 = Customer.builder()
                .First_Name("shani")
                .Last_Name("Aharonson")
                .email("Shani@shani.com")
                .coupon(coupon1)
                .coupon(coupon2)
                .coupon(coupon3)
                .coupon(coupon4)
                .password("1234")
                .build();

        Customer customer2 = Customer.builder()
                .First_Name("Ofir")
                .Last_Name("Aharonson")
                .email("Ofir@ofir.com")
                .password("5678")
                .coupon(coupon5)
                .coupon(coupon6)
                .coupon(coupon7)
                .coupon(coupon8)
                .build();

        Customer customer3 = Customer.builder()
                .First_Name("Yael")
                .Last_Name("Fridman")
                .email("Yael@yael.com")
                .password("9101112")

                .build();

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        System.out.println("Customers created!");
        System.out.println();
    }
}
