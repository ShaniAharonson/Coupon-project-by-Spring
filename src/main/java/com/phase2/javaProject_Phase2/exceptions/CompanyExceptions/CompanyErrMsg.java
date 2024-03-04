package com.phase2.javaProject_Phase2.exceptions.CompanyExceptions;

import lombok.Getter;

@Getter
public enum CompanyErrMsg {
    COMPANY_NOT_EXISTS("company not exists...");


    public String msg;


    CompanyErrMsg(String msg){this.msg=msg;}
    }



