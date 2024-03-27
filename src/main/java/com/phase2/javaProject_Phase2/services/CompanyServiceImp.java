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
import java.util.Optional;

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
        //get client
        //remove coupon from client coupon list
        //save the client
        //delete the coupon
        if (!couponRepository.existsById(couponId)) {
            throw new CompanySystemException(CompanyErrMsg.COUPON_NOT_FOUND);
        }
        Coupon couponToDelete = couponRepository.findById(couponId).get();
        companyRepository.findById(this.companyId).get().getCoupons().remove(couponToDelete);
//        couponToDelete.ifPresent(coupon -> {
//            //todo: problem!!!!!!!!!!
//            getAllCompanyCoupons().remove(coupon);
//            couponRepository.deleteById(couponId);
//        });
    }
    @Override
    public List<Coupon> getAllCompanyCoupons() throws CompanySystemException {
        return companyRepository.findById(this.companyId).orElseThrow(
                () -> new CompanySystemException(CompanyErrMsg.ID_NOT_FOUND)).getCoupons();
    }

    @Override
    public List<Coupon> getAllCompanyCouponsByCategory(Category category) {
        return couponRepository.findByIdAndCategoryId(this.companyId, category);

    }
    @Override
    public List<Coupon> getAllCompanyCouponsUpToMaxPrice(Double maxPrice, int companyId) throws CompanySystemException {
        int id = companyId;
        if (maxPrice<0){
            throw new CompanySystemException(CompanyErrMsg.MAX_PRICE_ERROR);
        }
        companyRepository.findById(companyId);
        return couponRepository.findByPriceLessThanAndId(maxPrice,companyId);
    }


    @Override
    public Company getCompanyDetails() throws CompanySystemException {
        return companyRepository.findById(this.companyId)
                .orElseThrow(() -> new CompanySystemException(CompanyErrMsg.COMPANY_NOT_EXISTS));
    }
}
