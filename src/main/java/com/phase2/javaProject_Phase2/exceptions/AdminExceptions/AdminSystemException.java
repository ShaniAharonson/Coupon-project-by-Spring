package com.phase2.javaProject_Phase2.exceptions.AdminExceptions;

import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminErrMsg;

public class AdminSystemException extends Exception{
    public AdminSystemException(AdminErrMsg adminErrMsg){
        super(adminErrMsg.getMsg());
    }
}
