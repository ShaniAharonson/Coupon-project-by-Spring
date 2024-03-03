package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponAlreadyExists;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImp {
    final CouponRepository couponRepository;

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    public Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
        Coupon coupon = couponRepository.findById(couponId).orElse(null);
        if (coupon==null){
            throw new CouponNotFoundException("coupon not found");
        }
        return coupon;
    }

    public void addCoupon(Coupon coupon) throws CouponAlreadyExists {
        if (couponRepository.existsById(coupon.getId())){
            throw new CouponAlreadyExists("Coupon alreadyExists!");
        }
        else {
            couponRepository.save(coupon);
        }
    }
    public List<Coupon> couponPriceLower(Double maxPrice){
        return couponRepository.priceLowerThan(maxPrice);
    }
}
