package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService{
    final CompanyRepository companyRepository;
    final CouponRepository couponRepository;

    @Override
    public boolean isCompanyExists(String email, String password) throws CompanySystemException {
        return false;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CompanySystemException {
        int id = coupon.getId();
        String title = coupon.getTitle();
        if (companyRepository.existsByTitleAndId(title,id)){
            throw new CompanySystemException(CompanyErrMsg.COUPON_TITLE_ALREADY_EXISTS);
        }
        couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CompanySystemException {
        if (!companyRepository.existsById(couponId)){
            throw new CompanySystemException(CompanyErrMsg.COUPON_NOT_FOUND);
        }
        couponRepository.saveAndFlush(coupon);

    }

    @Override
    public void deleteCoupon(int couponId) throws CompanySystemException {
        if (!companyRepository.existsById(couponId)){
            throw new CompanySystemException(CompanyErrMsg.COUPON_NOT_FOUND);
        }
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCompanyCoupons(int id) {
        return companyRepository.findAllByCompanyId(id);
        // is it ok?
    }

    @Override
    public List<Coupon> getAllCompanyCouponByCategory(Category category) throws CompanySystemException {
        return null;
    }

    @Override
    public List<Coupon> getAllCompanyCouponByPrice(Double maxPrice) throws CompanySystemException {
        return null;
    }

    @Override
    public Company companyDetails(int id) throws CompanySystemException {
        return null;
    }
}
