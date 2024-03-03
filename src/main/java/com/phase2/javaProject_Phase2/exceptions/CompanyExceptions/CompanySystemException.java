package com.phase2.javaProject_Phase2.exceptions.CompanyExceptions;

import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;

public class CompanySystemException extends Exception{
    public CompanySystemException(CompanyErrMsg companyErrMsg){
        super(companyErrMsg.getMsg());
    }
}
