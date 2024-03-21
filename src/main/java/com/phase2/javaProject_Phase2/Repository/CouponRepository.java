package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    Boolean existsByTitle(String title);
    List<Coupon> priceLessThan(Double MaxPrice);
//    List<Coupon> findByIdAndCategory(Integer id, String category);
    int findByAmount(int amount);
    @Query(value = "SELECT * FROM couponproject2.coupons where end_date = ?;",nativeQuery = true)
    Date findAllByEnd_Date(Date end_date);
    @Query(value = "SELECT * FROM couponproject2.coupons where category_id = ? AND company_ID = ?;",nativeQuery = true)
       List<Coupon> findByIdAndCategory_ID(Integer id, Category category_ID);




}
