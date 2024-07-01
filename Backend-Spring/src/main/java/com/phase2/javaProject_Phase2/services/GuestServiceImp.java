package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImp implements GuestService {
    final CouponRepository couponRepository;

    @Override
    public Coupon getSingleCoupon(Integer couponId) throws CouponSystemException {
        Coupon coupon = couponRepository.findById(couponId).orElse(null);
        if (coupon == null) {
            throw new CouponSystemException(CouponErrMsg.COUPON_NOT_FOUND);
        }
        return coupon;
    }

    @Override
    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }


}
