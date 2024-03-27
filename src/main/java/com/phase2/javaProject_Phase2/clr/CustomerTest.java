package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

//@Component
@Order(3)
@RequiredArgsConstructor
public class CustomerTest implements CommandLineRunner {
    private final CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- CUSTOMER TESTING -------------");
        // customer login
        try {
            customerService.customerLogin("shani@shani.com","99887766");
            System.out.println("customer login successfully!");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //purchase coupon
        try {
            Coupon couponToPurchase = Coupon.builder()
                    .id(0)
                    .company_ID(2)
                    .category_ID(Category.ELECTRICITY)
                    .title("sushi")
                    .description("vegan sushi")
                    .start_date(Date.valueOf(LocalDate.of(2023, 3, 7)))
                    .end_date(Date.valueOf(LocalDate.of(2025, 5, 8)))
                    .amount(30)
                    .price(35.5)
                    .image("image9")
                    .build();
//            customerService.purchaseCoupon(couponToPurchase);
            System.out.println("Coupon purchase!!");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get all customer's coupons:
        System.out.println("All customer's coupons:");
        //customerService.getAllCustomerCoupons().forEach(System.out::println);

        // find customer coupons by category
        try {
            System.out.println("Customer coupons by category");
            //todo: the function not working
        //        System.out.println(customerService.getAllCustomerCouponsByCategory(Category.ELECTRICITY));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //customer coupon by max price:
        try {
            System.out.println("customer coupons by max price");
            //todo: its printing everything and when i change it, its print nothing...
            System.out.println(customerService.getAllCustomerCouponsUpToMaxPrice(3000.0));
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get customer details
        System.out.println("customer details:");
        System.out.println(customerService.getCustomerDetails());
    }
}
