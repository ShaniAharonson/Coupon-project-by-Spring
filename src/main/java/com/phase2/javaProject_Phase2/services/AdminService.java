package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;

import java.util.List;

public interface AdminService {
    boolean isAdminExists(String email,String password) throws AdminSystemException;
    void addCompany(Company company) throws AdminSystemException;
    void updateCompany(int companyId, Company company) throws AdminSystemException;
    void deleteCompany(int companyId) throws AdminSystemException;
    List<Company> getAllCompanies();
    Company getSingleCompany(int companyId) throws AdminSystemException;
    void addCustomer(Customer customer) throws  AdminSystemException;
    void updateCustomer(int customerId, Customer customer) throws AdminSystemException;
    void deleteCustomer(int customerId) throws AdminSystemException;
    List<Customer> getAllCustomers();
    Customer getSingleCustomer(int customerId) throws AdminSystemException;

}
