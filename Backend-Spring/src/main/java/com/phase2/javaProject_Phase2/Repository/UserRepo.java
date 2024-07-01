package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.UserDetails;
import com.phase2.javaProject_Phase2.beans.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDetails, Integer> {
    //public boolean existsByEmailAndPassword(String email, String password);
    public UserDetails findByEmailAndPassword(String email, String password);
}