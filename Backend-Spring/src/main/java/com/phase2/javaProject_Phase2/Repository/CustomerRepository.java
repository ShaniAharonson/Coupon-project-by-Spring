package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Boolean existsByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);


}
