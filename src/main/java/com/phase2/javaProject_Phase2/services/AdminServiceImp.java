package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminErrMsg;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService{
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
private final String adminEmail = "admin@admin.com";
private final String  adminPass = "admin";
    @Override
    public boolean adminLogin(String email, String password) throws AdminSystemException {
        if (email.equals(adminEmail)&&password.equals(adminPass)){
            return true;
        }
        else {
            throw new AdminSystemException(AdminErrMsg.ADMIN_NOT_EXISTS);
        }
    }

    @Override
    public void addCompany(Company company) throws AdminSystemException {

        String companyName = company.getName();
        if (companyRepository.existsByName(companyName)){
            throw new AdminSystemException(AdminErrMsg.COMPANY_NAME_ALREADY_EXISTS);
        }
        String email = company.getEmail();
        if (companyRepository.existsByEmail(email)){
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws AdminSystemException {
        int companyId = company.getId();
        if (!companyRepository.existsById(companyId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        String name = company.getName();
        if (companyRepository.existsByName(name)){
            throw new AdminSystemException(AdminErrMsg.COMPANY_NAME_ERROR);
        }
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws AdminSystemException {
        if (!companyRepository.existsById(companyId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        companyRepository.deleteById(companyId);

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int CompanyId) throws AdminSystemException {
        return companyRepository.findById(CompanyId).orElseThrow(()->
                new AdminSystemException(AdminErrMsg.ID_NOT_FOUND));
    }

    @Override
    public void addCustomer(Customer customer) throws AdminSystemException {
        int id = customer.getId();
        if (customerRepository.existsById(id)){
            throw new AdminSystemException(AdminErrMsg.CUSTOMER_ID_ALREADY_EXISTS);
        }
        String email = customer.getEmail();
        if (customerRepository.existsByEmail(email)){
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws AdminSystemException {
        if (!customerRepository.existsById(customerId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        customerRepository.saveAndFlush(customer);
    }
    @Override
    public void deleteCustomer(int customerId) throws AdminSystemException {
        if (!customerRepository.existsById(customerId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws AdminSystemException {
        return customerRepository.findById(customerId).orElseThrow(()->
               new AdminSystemException(AdminErrMsg.ID_NOT_FOUND));
    }
}
