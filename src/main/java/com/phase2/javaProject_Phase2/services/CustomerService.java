package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;

import java.util.List;

public interface CustomerService {
    Boolean customerLogin(String email, String password) throws CustomerSystemException;
    void purchaseCoupon(Coupon coupon) throws CouponSystemException;
    List<Coupon> getAllCustomerCoupons() throws CustomerSystemException;
    List<Coupon> getAllCustomerCouponsByCategory(Category category) throws CustomerSystemException;
    List<Coupon> getAllCustomerCouponsUpToMaxPrice(Double maxPrice) throws CustomerSystemException;
    Customer getCustomerDetails() throws CustomerSystemException;
}
