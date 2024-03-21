package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;

public interface GuestService {



    Coupon getSingleCoupon(Integer couponId) throws CouponSystemException;




}

