package com.phase2.javaProject_Phase2.exceptions.CustomerExceptions;

import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminErrMsg;

public class CustomerSystemException extends Exception{
    public CustomerSystemException(CustomerErrMsg customerErrMsg){
        super(customerErrMsg.getMsg());
    }
}
