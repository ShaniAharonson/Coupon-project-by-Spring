package com.phase2.javaProject_Phase2.exceptions.CouponExceptions;

import lombok.Getter;

@Getter
public enum CouponErrMsg {
    COUPON_ALREADY_EXISTS("coupon already exists"),
    COUPON_TITLE_ALREADY_EXISTS("Coupon title already exists"),
    CANNOT_UPDATE_COUPON("cannot update coupon"),
    COUPON_BY_CATEGORY_NOT_FOUND("coupon by this category is not found"),
    COUPON_NOT_FOUND("Coupon not found");
    public String msg;
    CouponErrMsg(String msg){this.msg=msg;}
}
