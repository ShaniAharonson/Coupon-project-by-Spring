package com.phase2.javaProject_Phase2.clr.clrCoupon;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
//@Order(12)
public class DeleteCoupon implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;


    @Override
    public void run(String... args) throws Exception {
        Optional<Coupon> couponToDelete = couponRepository.findById(8);
        couponToDelete.ifPresent((coupon -> {

            couponRepository.deleteById(8);
            System.out.println("Coupon deleted!");
            System.out.println();
        }));
    }
}
