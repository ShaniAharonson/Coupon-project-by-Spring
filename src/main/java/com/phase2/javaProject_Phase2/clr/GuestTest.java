package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(4)
@RequiredArgsConstructor
public class GuestTest implements CommandLineRunner {
    private final GuestService guestService;

    @Override
    public void run(String... args) throws Exception {
        // getting all coupons
        System.out.println("All coupons:");
        guestService.getAllCoupons().forEach(System.out::println);

        // getting single coupon
        System.out.println("single coupon");
        System.out.println(guestService.getSingleCoupon(1));
    }
}
