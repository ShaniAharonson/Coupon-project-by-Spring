package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;

import java.util.List;

public interface CompanyService {
    int companyLogin(String email, String password) throws CompanySystemException;
    int addCoupon(Coupon coupon) throws CompanySystemException;
    boolean updateCoupon(Coupon coupon) throws CompanySystemException;
    boolean deleteCoupon(int id) throws CompanySystemException;
    List<Coupon> getAllCompanyCoupons(int companyId) throws CompanySystemException;
    List<Coupon> getAllCompanyCouponsByCategory(String category, int companyId) throws CouponSystemException;
    List<Coupon> getAllCompanyCouponsUpToMaxPrice(int id, Double maxPrice) throws CompanySystemException;
    Company getCompanyDetails(int companyId) throws CompanySystemException;
}