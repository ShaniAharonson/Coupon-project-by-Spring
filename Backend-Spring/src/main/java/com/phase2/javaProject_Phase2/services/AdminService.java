package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;

import java.util.List;

public interface AdminService {

 boolean adminLogin(String email, String password) throws AdminSystemException;
 int addCompany(Company company) throws AdminSystemException;
 boolean updateCompany (Company company) throws AdminSystemException;
 boolean deleteCompany(int companyId) throws AdminSystemException;
 List<Company> getAllCompanies();
 Company getSingleCompany(int CompanyId) throws AdminSystemException;
 boolean addCustomer(Customer customer) throws AdminSystemException;
 boolean updateCustomer(Customer customer) throws AdminSystemException;
 boolean deleteCustomer(int customerId) throws AdminSystemException;
 List<Customer> getAllCustomers();
 Customer getSingleCustomer(int customerId) throws AdminSystemException;
}