package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;

public interface CompanyService {
    boolean companyLogin(String email, String password) throws CompanySystemException;

   Company getCompanyDetails() throws CompanySystemException;

}
