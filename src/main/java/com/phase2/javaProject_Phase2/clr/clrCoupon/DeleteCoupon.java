package com.phase2.javaProject_Phase2.clr.clrCoupon;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
//@Component
@Order(11)
public class DeleteCoupon implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;


    @Override
    public void run(String... args) throws Exception {
        //in the service !!!!!!!!!!
        //get client
        //remove coupon from client coupon list
        //save the client
        //delete the coupon
        Optional<Coupon> couponToDelete = couponRepository.findById(6);
        couponToDelete.ifPresent((coupon -> {

            couponRepository.deleteById(6);
            System.out.println("Coupon deleted!");
            System.out.println();
        }));
    }
}
