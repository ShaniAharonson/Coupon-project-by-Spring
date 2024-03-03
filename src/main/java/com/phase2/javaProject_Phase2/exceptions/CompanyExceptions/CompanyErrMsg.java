package com.phase2.javaProject_Phase2.exceptions.CompanyExceptions;

import lombok.Getter;

@Getter
public enum CompanyErrMsg {
    COMPANY_NOT_EXISTS("company not exists..."),
    COUPON_TITLE_ALREADY_EXISTS("Coupon title already exists"),
    CANNOT_UPDATE_COUPON("cannot update coupon"),
    COUPON_NOT_FOUND("Coupon not found");

    public String msg;


    CompanyErrMsg(String msg){this.msg=msg;}
    }



