package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.AdminService;
import com.phase2.javaProject_Phase2.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.sql.Date;
import java.time.LocalDate;

//@Component
@Order(2)
@RequiredArgsConstructor
public class CompanyTest implements CommandLineRunner {
    private final CompanyService companyService;
    private final AdminService adminService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- COMPANY TESTING -------------");
        // company login
        try {
            companyService.companyLogin("Apple@apple.com", "202020");
            System.out.println("company login successfully");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        // add coupon
        try {
            companyService.addCoupon(new Coupon(0, 2, Category.ELECTRICITY, "phones", "GALAXY S 22",
                    Date.valueOf(LocalDate.of(2023, 12, 22)),
                    Date.valueOf(LocalDate.of(2025, 12, 25)), 200, 1000.0,
                    "image8"));
            companyService.addCoupon(new Coupon(0,2, Category.VACATION,"Thailand","vacation in thailand",
                    Date.valueOf(LocalDate.of(2023,11,2)),Date.valueOf(LocalDate.of(
                            2024,8,1)),30,3999.9,"image13"));
            System.out.println("coupon added");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // update coupon
        try {
            companyService.updateCoupon(Coupon.builder()
                    .id(2)
                    .companyId(2)
                    .categoryId(Category.ELECTRICITY)
                    .title("Playstation")
                    .description("Big fun for all")
                    .startDate(Date.valueOf(LocalDate.of(2023, 6, 15)))
                    .endDate(Date.valueOf(LocalDate.of(2025, 11, 8)))
                    .amount(50)
                    .price(200.0)
                    .image("image 8")
                    .build());

            System.out.println("Coupon is updated!");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // delete coupon
        try {
          companyService.deleteCoupon(7);

            System.out.println("Coupon is deleted!");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // get all company's coupons
        try {
            System.out.println("All company's coupons:");
            companyService.getAllCompanyCoupons(2).forEach(System.out::println);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
       // get all company's coupons by category
        try {
            System.out.println("Company's coupons by category:");
            System.out.println(companyService.getAllCompanyCouponsByCategory("ELECTRICITY",2));
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

         // get coupon up to max price
        try {
            System.out.println("Getting all coupons up to max price:");
            System.out.println(companyService.getAllCompanyCouponsUpToMaxPrice(2,4000.0));
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        // company details:
        try {
            System.out.println("company details");
        System.out.println(companyService.getCompanyDetails(2));
        } catch (Exception err){
            System.out.println(err.getMessage());
        }


    }
}