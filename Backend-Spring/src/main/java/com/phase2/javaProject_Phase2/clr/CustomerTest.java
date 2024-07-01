package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

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
           // customerService.customerLogin("shani@shani.com","99887766");
            System.out.println("customer login successfully!");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //purchase coupon
        try {
            Coupon couponToPurchase = Coupon.builder()
                    .id(6)
                    .companyId(2)
                    .categoryId(Category.ELECTRICITY)
                    .title("phones")
                    .description("GALAXY S 22")
                    .startDate(Date.valueOf(LocalDate.of(2023, 12, 22)))
                    .endDate(Date.valueOf(LocalDate.of(2025, 12, 25)))
                    .amount(200)
                    .price(1000.0)
                    .image("image8")
                    .build();
            customerService.purchaseCoupon(3,2);
            System.out.println("Coupon purchase!!");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get all customer's coupons:
        System.out.println("All customer's coupons:");
        customerService.getAllCustomerCoupons(2).forEach(System.out::println);

        // find customer coupons by category
        try {
            System.out.println("Customer coupons by category");
                System.out.println(customerService.getAllCustomerCouponsByCategory("electricity",2));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //customer coupon by max price:
        try {
            System.out.println("customer coupons by max price");
            System.out.println(customerService.getAllCustomerCouponsUpToMaxPrice(3000.0,2));
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get customer details
        System.out.println("customer details:");
        System.out.println(customerService.getCustomerDetails(2));


    }
}
