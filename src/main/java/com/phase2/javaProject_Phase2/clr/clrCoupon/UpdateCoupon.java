package com.phase2.javaProject_Phase2.clr.clrCoupon;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
@Order(12)
public class UpdateCoupon implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Coupon> updateCoupon = couponRepository.findById(1);
        System.out.println("Coupon to update:");
        updateCoupon.ifPresent(System.out::println);
        System.out.println();
        updateCoupon.ifPresent((coupon -> {
            coupon.setAmount(1500);
            couponRepository.saveAndFlush(coupon);
            System.out.println("Coupon is updated!");
            System.out.println();
        }));
    }
}
