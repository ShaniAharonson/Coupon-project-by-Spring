package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(1)
@RequiredArgsConstructor
public class AdminTest implements CommandLineRunner {
    private final AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- COMPANIES -------------");
        System.out.println(adminService.adminLogin("admin@admin.com", "admin"));

        // add company
        Company company1 = Company.builder()
                .name("Microsoft")
                .email("Microsoft@microsoft.com")
                .password("101010")
                .coupon(new Coupon(1, Category.ELECTRICITY, "Computer", "DEL computer",
                        Date.valueOf(LocalDate.of(2022, 5, 2)),
                        Date.valueOf(LocalDate.of(2028, 9, 1)), 2000, 2500.0,
                        "image4"))
                .build();

        Company company2 = Company.builder()
                .name("Apple")
                .email("Apple@apple.com")
                .password("202020")
                .coupon(new Coupon(2, Category.RESTAURANT, "VIVINO", "family meal in vivino",
                        Date.valueOf(LocalDate.of(2023, 4, 4)),
                        Date.valueOf(LocalDate.of(2024, 7, 29)), 40, 250.0,
                        "image3"))
                .build();

        Company company3 = Company.builder()
                .name("Nvidia")
                .email("Nvidia@nvidia.com")
                .password("303030")
                .coupon(new Coupon(3, Category.VACATION, "paris trip", "romantic trip for couples",
                        Date.valueOf(LocalDate.of(2021, 11, 22)),
                        Date.valueOf(LocalDate.of(2026, 7, 12)), 300, 1500.0,
                        "image2"))
                .build();

        Company company4 = Company.builder()
                .name("Testing")
                .email("test@test.com")
                .password("11121")
                .coupon(new Coupon(4, Category.FOOD, "Hamburger", "hamburger & chips",
                        Date.valueOf(LocalDate.of(2022, 8, 29)),
                        Date.valueOf(LocalDate.of(2025, 12, 25)), 200, 25.5,
                        "image"))
                .build();

//        adminService.addCompany(company1);
//        adminService.addCompany(company2);
//        adminService.addCompany(company3);
//        adminService.addCompany(company4);

        System.out.println("Companies created!");
        System.out.println();

        // update company
//        adminService.updateCompany(Company.builder()
//                .id(4)
//                .name("Google")
//                .email("google@google.com")
//                .password("767676")
//                .build());
//
//        System.out.println("company updated!");
    }


}
