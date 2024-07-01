package com.phase2.javaProject_Phase2.exceptions.CouponExceptions;

import lombok.Getter;

@Getter
public enum CouponErrMsg {


    CANNOT_UPDATE_COUPON("cannot update coupon"),
    COUPON_BY_CATEGORY_NOT_FOUND("coupon by this category is not found"),
    COUPON_NOT_FOUND("Coupon not found"),
    PURCHASE_ERROR("cannot purchase the same coupon"),
    AMOUNT_ERROR("amount is lower than 0"),
    COUPON_IS_EXPIRED("coupon is expired"),
    NOT_ADMIN("Not an Admin");
    public String msg;
    CouponErrMsg(String msg){this.msg=msg;}
}
