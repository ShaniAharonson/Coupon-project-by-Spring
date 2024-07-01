package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;

import java.util.List;

public interface CustomerService {
    int customerLogin(String email, String password) throws CustomerSystemException;
    boolean purchaseCoupon(int customerId, int couponId) throws CouponSystemException, CustomerSystemException;
    List<Coupon> getAllCustomerCoupons(int customerId) throws CustomerSystemException;
    List<Coupon> getAllCustomerCouponsByCategory(String category, int id) throws CustomerSystemException;
    List<Coupon> getAllCustomerCouponsUpToMaxPrice(Double maxPrice, int id) throws CustomerSystemException;
    Customer getCustomerDetails(int id) throws CustomerSystemException;
}