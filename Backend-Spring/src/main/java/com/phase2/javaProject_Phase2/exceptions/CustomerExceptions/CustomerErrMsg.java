package com.phase2.javaProject_Phase2.exceptions.CustomerExceptions;

import lombok.Getter;

@Getter
public enum CustomerErrMsg {
    ID_NOT_FOUND("Id not found"),
    CUSTOMER_NOT_EXISTS("Customer not exists..."),
    CANNOT_PURCHASE_COUPON_MORE_tHAN_ONE("cannot purchase coupon more than one"),
    CANNOT_PURCHASE_IF_AMOUNT_IS_ZERO("Cannot purchase if amount is 0"),
    CANNOT_PURCHASE_EXPIRED_COUPON("cannot purchase expired coupon"),
    CUSTOMER_LOGIN_ERROR("cannot login customer..."),
    MAX_PRICE_ERROR("price must be more than 0"),
    COUPON_ALREADY_PURCHASED("coupon already purchased"),
    CATEGORY_NOT_FOUND("category not found");


    private String msg;

    CustomerErrMsg(String msg){this.msg=msg;}

}
