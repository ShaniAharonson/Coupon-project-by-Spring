package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

}
