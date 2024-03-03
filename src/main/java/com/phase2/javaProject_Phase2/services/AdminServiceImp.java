package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminErrMsg;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanyErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {
    public final CompanyRepository companyRepository;
    public final CustomerRepository customerRepository;

    @Override

    public boolean isAdminExists(String email, String password) throws AdminSystemException {
        return false;
    }

    @Override
    public void addCompany(Company company) throws AdminSystemException {
        int id = company.getId();
        String email = company.getEmail();
        String name = company.getName();
        if (companyRepository.existsByName(name)) {
            throw new AdminSystemException(AdminErrMsg.COMPANY_NAME_ALREADY_EXISTS);
        } else if (companyRepository.existsByEmail(email)) {
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        } else if (companyRepository.existsById(id)) {
            throw new AdminSystemException(AdminErrMsg.COMPANY_ID_ALREADY_EXISTS);
        }
            companyRepository.save(company);


    }

    @Override
    public void updateCompany(int companyId, Company company) throws AdminSystemException {
        if (!companyRepository.existsById(company.getId())){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
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
    public Company getSingleCompany(int companyId) throws AdminSystemException {
        return companyRepository.findById(companyId).orElseThrow(
                ()-> new AdminSystemException(AdminErrMsg.ID_NOT_FOUND));
    }

    @Override
    public void addCustomer(Customer customer) throws AdminSystemException {
        String email = customer.getEmail();
        int id = customer.getId();
        if (customerRepository.existsByEmail(email)){
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        } else if (customerRepository.existsById(id)) {
            throw new AdminSystemException(AdminErrMsg.CUSTOMER_ID_ALREADY_EXISTS);

        }
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws AdminSystemException {
        if (!companyRepository.existsById(customer.getId())){
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
        return customerRepository.findById(customerId).orElseThrow(
                ()-> new AdminSystemException(AdminErrMsg.ID_NOT_FOUND));
    }
}
