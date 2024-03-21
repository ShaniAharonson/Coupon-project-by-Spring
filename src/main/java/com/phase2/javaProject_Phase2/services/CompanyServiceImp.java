package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CouponRepository couponRepository;
    private int companyId;

    @Override
    public Boolean companyLogin(String email, String password) throws CompanySystemException {
//        if (!companyRepository.existsByEmailAndPassword(email, password)) {
//            throw new CompanySystemException(CompanyErrMsg.COMPANY_LOGIN_ERROR);
//        }
//
        Company company = companyRepository.findByEmailAndPassword(email, password);
        if (company == null) {
            throw new CompanySystemException(CompanyErrMsg.COMPANY_LOGIN_ERROR);
        }
        this.companyId = company.getId();
        return true;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CompanySystemException {
        int id = coupon.getId();
        if (couponRepository.existsById(id)) {
            throw new CompanySystemException(CompanyErrMsg.COUPON_ALREADY_EXISTS);
        }
        String title = coupon.getTitle();
        if (couponRepository.existsByTitle(title)) {
            throw new CompanySystemException(CompanyErrMsg.COUPON_TITLE_ALREADY_EXISTS);
        }
        couponRepository.save(coupon);

    }

    @Override
    public void updateCoupon(Coupon coupon) throws CompanySystemException {
        int couponId = coupon.getId();
        if (!couponRepository.existsById(couponId)) {
            throw new CompanySystemException(CompanyErrMsg.COUPON_NOT_FOUND);
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CompanySystemException {
        if (!couponRepository.existsById(couponId)) {
            throw new CompanySystemException(CompanyErrMsg.COUPON_NOT_FOUND);
        }
//        Optional<Coupon> couponToDelete = couponRepository.findById(couponId);
//        couponToDelete.ifPresent(coupon -> {
//            getAllCompanyCoupons().remove(coupon);
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCompanyCoupons() throws CompanySystemException {
        return companyRepository.findById(this.companyId).orElseThrow(
                () -> new CompanySystemException(CompanyErrMsg.ID_NOT_FOUND)).getCoupons();
    }

    @Override
    public List<Coupon> getAllCompanyCouponsByCategory(Category category) {
        return couponRepository.findByIdAndCategory_ID(this.companyId, category);
    }
    @Override
    public List<Coupon> getAllCompanyCouponsUpToMaxPrice(Double maxPrice) throws CompanySystemException {
        if (maxPrice<0){
            throw new CompanySystemException(CompanyErrMsg.MAX_PRICE_ERROR);
        }
        return couponRepository.priceLessThan(maxPrice);
    }

    @Override
    public Company getCompanyDetails() throws CompanySystemException {
        return companyRepository.findById(this.companyId)
                .orElseThrow(() -> new CompanySystemException(CompanyErrMsg.COMPANY_NOT_EXISTS));
    }
}
