package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CouponRepository;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public boolean companyLogin(String email, String password) throws CompanySystemException {
        return false;
    }


    @Override
    public Company getCompanyDetails() throws CompanySystemException {
        return null;
    }
}
