package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService{
    public final CustomerRepository customerRepository;

    @Override
    public Boolean customerLogin(String email, String password) throws CustomerSystemException {
        return null;
    }

    @Override
    public Customer getCustomerDetails() throws CustomerSystemException {
        return null;
    }
}
