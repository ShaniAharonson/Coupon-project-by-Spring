package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByName(String name);
    Boolean existsByName (String name);
    Boolean existsByEmail(String email);
    Company findByEmail(String email);
    Company findByEmailAndPassword(String email, String password);



}
