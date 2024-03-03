package com.phase2.javaProject_Phase2.exceptions.CustomerExceptions;

import lombok.Getter;

@Getter
public enum CustomerErrMsg {
    CUSTOMER_NOT_EXISTS("Customer not exists..."),
    CANNOT_PURCHASE_COUPON_MORE_tHAN_ONE("cannot purchase coupon more than one"),
    CANNOT_PURCHASE_IF_AMOUNT_IS_ZERO("Cannot purchase if amount is 0"),
    CANNOT_PURCHASE_EXPIRED_COUPON("cannot purchase expired coupon");

    private String msg;

    CustomerErrMsg(String msg){this.msg=msg;}

}
