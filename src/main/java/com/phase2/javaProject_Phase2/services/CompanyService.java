package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;

import java.util.List;

public interface CompanyService {
    boolean isCompanyExists(String email,String password) throws CompanySystemException;
    void addCoupon(Coupon coupon) throws CompanySystemException;
    void updateCoupon(int couponId, Coupon coupon) throws CompanySystemException;
    void deleteCoupon(int couponId) throws CompanySystemException;
    List<Coupon> getAllCompanyCoupons(int id); // is it o.k?
    List<Coupon> getAllCompanyCouponByCategory(Category category) throws CompanySystemException;
    List<Coupon> getAllCompanyCouponByPrice(Double maxPrice) throws CompanySystemException;
    Company companyDetails(int id) throws CompanySystemException ;
}
