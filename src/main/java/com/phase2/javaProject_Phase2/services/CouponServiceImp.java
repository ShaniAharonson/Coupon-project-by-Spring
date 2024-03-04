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
public class CouponServiceImp implements CouponService {
    final CouponRepository couponRepository;

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        int id = coupon.getId();
        if (couponRepository.existsById(id)) {
            throw new CouponSystemException(CouponErrMsg.COUPON_ALREADY_EXISTS);
        }
        String title = coupon.getTitle();
        if (couponRepository.existsByTitle(title)) {
            throw new CouponSystemException(CouponErrMsg.COUPON_TITLE_ALREADY_EXISTS);
        }
        couponRepository.save(coupon);

    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {
        if (!couponRepository.existsById(couponId)) {
            throw new CouponSystemException(CouponErrMsg.COUPON_NOT_FOUND);
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if (!couponRepository.existsById(couponId)) {
            throw new CouponSystemException(CouponErrMsg.COUPON_NOT_FOUND);
        }
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public List<Coupon> getAllCouponsByCategory(int category) throws CouponSystemException {
        return null;
    }

    @Override
    public List<Coupon> getAllCouponsUpToMaxPrice(Double maxPrice) throws CouponSystemException {
        return couponRepository.priceLowerThan(maxPrice);
    }

    @Override
    public Coupon getCouponById(Integer couponId) throws CouponSystemException {
        Coupon coupon = couponRepository.findById(couponId).orElse(null);
        if (coupon == null) {
            throw new CouponSystemException(CouponErrMsg.COUPON_NOT_FOUND);
        }
        return coupon;
    }

}
