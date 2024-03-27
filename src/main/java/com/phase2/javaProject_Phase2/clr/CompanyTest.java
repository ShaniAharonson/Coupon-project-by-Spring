package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.AdminService;
import com.phase2.javaProject_Phase2.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
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
            companyService.addCoupon(new Coupon(0, 1, Category.ELECTRICITY, "phones", "GALAXY S 22",
                    Date.valueOf(LocalDate.of(2023, 12, 22)),
                    Date.valueOf(LocalDate.of(2025, 12, 25)), 200, 1000.0,
                    "image8"));
            System.out.println("coupon added");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // update coupon
        try {
//            companyService.updateCoupon(Coupon.builder()
//                    .id(7)
//                    .company_ID(3)
//                    .category_ID(Category.FOOD)
//                    .title("Hamburger")
//                    .description("Family hamburger deal")
//                    .start_date(Date.valueOf(LocalDate.of(2023, 6, 15)))
//                    .end_date(Date.valueOf(LocalDate.of(2025, 11, 8)))
//                    .amount(50)
//                    .price(200.0)
//                    .image("image 8")
//                    .build());

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // delete coupon
        try {
            //todo = build funcgion to save and flush company
//           Company getSingleCompany = adminService.getSingleCompany(2);
//           List<Coupon> coupons = getSingleCompany.getCoupons();
//           coupons.forEach(System.out::println);
//           coupons.clear();

           companyService.deleteCoupon(2);
           companyService.deleteCoupon(6);
            // getSingleCompany.setCoupons(null);
            // companyService.deleteCoupon(6);

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // get all company's coupons
        try {
            System.out.println("All company's coupon:");
            companyService.getAllCompanyCoupons().forEach(System.out::println);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
        // get all company's coupons by category
        try {
            //todo: why is not working?!
            System.out.println("Company's coupons by category:");
            System.out.println(companyService.getAllCompanyCouponsByCategory(Category.RESTAURANT));
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // get coupon up to max price
        try {
            System.out.println("Get all coupons up to max price:");
            System.out.println(companyService.getAllCompanyCouponsUpToMaxPrice(4000.0,1));
            //todo: cannot print only coupons for specific company.. its prints everything
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        // company details:
        try {
            System.out.println("company details");
//        System.out.println(companyService.getCompanyDetails());
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }
}