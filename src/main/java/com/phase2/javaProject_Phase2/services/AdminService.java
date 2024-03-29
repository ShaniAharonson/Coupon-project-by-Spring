package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;

import java.util.List;

public interface AdminService {

   boolean adminLogin(String email, String password) throws AdminSystemException;
    void addCompany(Company company) throws AdminSystemException;
    void updateCompany (Company company) throws AdminSystemException;
    void deleteCompany(int companyId) throws AdminSystemException;
    List<Company> getAllCompanies();
    Company getSingleCompany(int CompanyId) throws AdminSystemException;
    void addCustomer(Customer customer) throws AdminSystemException;
    void updateCustomer(Customer customer) throws AdminSystemException;
    void deleteCustomer(int customerId) throws AdminSystemException;
    List<Customer> getAllCustomers();
    Customer getSingleCustomer(int customerId) throws AdminSystemException;
}
