package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.EnumCategory;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;

import java.util.List;

public interface CouponService {
    void addCoupon(Coupon coupon) throws CouponSystemException;
    void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException;
    void deleteCoupon(int couponId) throws CouponSystemException;
    List<Coupon> getAllCoupons();
    List<Coupon> getAllCouponsByCategory(Category category) throws CouponSystemException;

    List<Coupon> getAllCouponsUpToMaxPrice(Double maxPrice) throws CouponSystemException;
    Coupon getCouponById(Integer couponId) throws CouponSystemException;
}
