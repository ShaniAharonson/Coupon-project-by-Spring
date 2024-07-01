package com.phase2.javaProject_Phase2.exceptions.AdminExceptions;

import lombok.Getter;

@Getter
public enum AdminErrMsg {
    ADMIN_NOT_EXISTS("Admin not exists..."),
    CANNOT_UPDATE_EMAIL("cannot update email"),
    COMPANY_NAME_ALREADY_EXISTS("Cannot add the same company name"),
    EMAIL_ALREADY_EXISTS("email already exists, find other email to use..."),
    COMPANY_ID_ALREADY_EXISTS("company id already exists"),
    CUSTOMER_ID_ALREADY_EXISTS("customer id already exists"),
    CANNOT_CHANGE_COMPANY_PASSWORD("cannot change company password"),
    CANNOT_ADD_CUSTOMER_WITH_SAME_EMAIL("cannot add customer with the same email"),
    CANNOT_UPDATE_CUSTOMER("cannot update customer"),
    ID_NOT_FOUND("ID not found"),
    COMPANY_NAME_ERROR("cannot change company's name");

    private String msg;
    AdminErrMsg(String msg){this.msg=msg;}



}
