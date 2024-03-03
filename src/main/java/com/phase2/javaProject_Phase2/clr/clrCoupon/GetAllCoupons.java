package com.phase2.javaProject_Phase2.clr.clrCoupon;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(13)
public class GetAllCoupons implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Coupon> allCoupons = couponRepository.findAll();
        System.out.println("All Coupons:");
        allCoupons.forEach(System.out::println);
        System.out.println();
    }
}
