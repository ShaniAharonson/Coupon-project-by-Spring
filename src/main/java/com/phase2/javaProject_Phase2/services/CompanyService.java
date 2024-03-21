package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;

import java.util.List;

public interface CompanyService {
    Boolean companyLogin(String email, String password) throws CompanySystemException;
    void addCoupon(Coupon coupon) throws CompanySystemException;
    void updateCoupon(Coupon coupon) throws CompanySystemException;
    void deleteCoupon(int couponId) throws CompanySystemException;
    List<Coupon> getAllCompanyCoupons() throws CompanySystemException;
    List<Coupon> getAllCompanyCouponsByCategory(Category category) throws CouponSystemException;
    List<Coupon> getAllCompanyCouponsUpToMaxPrice(Double maxPrice) throws CompanySystemException;
   Company getCompanyDetails() throws CompanySystemException;
}
