package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CompanyRepository;
import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.beans.UserType;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminErrMsg;
import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService{
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
   // private final UserService userService;


    @Override
    public boolean adminLogin(String email, String password) throws AdminSystemException {
        final String adminEmail = "admin@admin.com";
        final String adminPass = "admin";
        if (email.equals(adminEmail)&&password.equals(adminPass)){
            return true;
        }
        else {
            throw new AdminSystemException(AdminErrMsg.ADMIN_NOT_EXISTS);
        }
    }

    @Override
    public int addCompany(Company company) throws AdminSystemException {
        String companyName = company.getName();
        if (companyRepository.findByName(companyName)!=null){
            throw new AdminSystemException(AdminErrMsg.COMPANY_NAME_ALREADY_EXISTS);
        }
        String email = company.getEmail();
        if (companyRepository.findByEmail(email)!=null){
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        }
        var newCompany = companyRepository.save(company);
        //userService.addCredentials(company.getName(), company.getPassword(), UserType.COMPANY, company.getEmail());
        System.out.println(newCompany.getId());
        return newCompany.getId();
    }

    @Override
    public boolean updateCompany(Company company) throws AdminSystemException {
        int id = company.getId();
        if (!companyRepository.existsById(id)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        String name = company.getName();
        if (!companyRepository.existsByName(name)){
            throw new AdminSystemException(AdminErrMsg.COMPANY_NAME_ERROR);
        }
        companyRepository.saveAndFlush(company);
        return true;
    }

    @Override
    public boolean deleteCompany(int companyId) throws AdminSystemException {
        if (!companyRepository.existsById(companyId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        Company company = getSingleCompany(companyId);
        company.setCoupons(null);
        companyRepository.deleteById(companyId);
        return true;
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
    public boolean addCustomer(Customer customer) throws AdminSystemException {
        String email = customer.getEmail();
        if (customerRepository.existsByEmail(email)){
            throw new AdminSystemException(AdminErrMsg.EMAIL_ALREADY_EXISTS);
        }
        customerRepository.save(customer);
        //userService.addCredentials(customer.getFirstName(), customer.getPassword(), UserType.CUSTOMER, customer.getEmail());
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws AdminSystemException {

        if (!customerRepository.existsById(customer.getId())){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        customerRepository.saveAndFlush(customer);
        return true;
    }
    @Override
    public boolean deleteCustomer(int customerId) throws AdminSystemException {
        if (!customerRepository.existsById(customerId)){
            throw new AdminSystemException(AdminErrMsg.ID_NOT_FOUND);
        }
        Customer customer = getSingleCustomer(customerId);
        customer.setCoupons(null);
        customerRepository.deleteById(customerId);
        return true;
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
