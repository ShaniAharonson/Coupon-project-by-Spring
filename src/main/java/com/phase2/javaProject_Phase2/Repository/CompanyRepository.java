package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndPassword(String email, String password);
    Company findByEmailAndPassword(String email, String password);




}
