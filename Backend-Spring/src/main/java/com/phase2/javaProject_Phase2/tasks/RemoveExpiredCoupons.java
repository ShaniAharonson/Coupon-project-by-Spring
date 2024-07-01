package com.phase2.javaProject_Phase2.tasks;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class RemoveExpiredCoupons {
    private final CouponRepository couponRepository;
    @Scheduled(cron = "0 0 2 * * *")
    public void deleteCoupons(){
        couponRepository.expiredCoupons();
        System.out.println("Deleting old coupons");
    }

}
