package com.phase2.javaProject_Phase2.exceptions.CouponExceptions;

public class CouponSystemException extends Exception{
    public CouponSystemException(CouponErrMsg couponErr){
        super(couponErr.getMsg());
    }
}
