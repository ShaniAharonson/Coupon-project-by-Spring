package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;

public interface CustomerService {
    Boolean customerLogin(String email, String password) throws CustomerSystemException;
    Customer getCustomerDetails() throws CustomerSystemException;
}
