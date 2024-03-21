package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private int customerId;
    public final CustomerRepository customerRepository;
    public final CouponRepository couponRepository;

    @Override
    public Boolean customerLogin(String email, String password) throws CustomerSystemException {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);

        if (customer==null) {
            throw new CustomerSystemException(CustomerErrMsg.CUSTOMER_LOGIN_ERROR);
        }
        this.customerId=customer.getId();
        return true;

    }
    @Override
    public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
        int id = coupon.getId();
        int amount = coupon.getAmount();
        Date endDate = coupon.getEnd_date();

        if (couponRepository.existsById(id)) {
            throw new CouponSystemException(CouponErrMsg.PURCHASE_ERROR);
        }
        if (couponRepository.findByAmount(amount) < 0) {
            throw new CouponSystemException(CouponErrMsg.AMOUNT_ERROR);
        }
        if (couponRepository.findAllByEnd_Date(endDate).after(Date.valueOf(LocalDate.now()))) {
            throw new CouponSystemException(CouponErrMsg.COUPON_IS_EXPIRED);
        }
        coupon.setAmount(amount-1);
        couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> getAllCustomerCoupons() throws CustomerSystemException {
        return customerRepository.findById(this.customerId).orElseThrow(
                () -> new CustomerSystemException(CustomerErrMsg.ID_NOT_FOUND)).getCoupons();
    }

    @Override
    public List<Coupon> getAllCustomerCouponsByCategory(Category category) throws CustomerSystemException {
        return couponRepository.findByIdAndCategory_ID(this.customerId, category);
    }

    @Override
    public List<Coupon> getAllCustomerCouponsUpToMaxPrice(Double maxPrice) throws CustomerSystemException {
        if (maxPrice<0){
            throw new CustomerSystemException(CustomerErrMsg.MAX_PRICE_ERROR);
        }
        return couponRepository.priceLessThan(maxPrice);
    }

    @Override
    public Customer getCustomerDetails() throws CustomerSystemException {
        return null;
    }
}
