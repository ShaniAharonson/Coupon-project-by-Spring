package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp {
    final CustomerRepository customerRepository;
}
