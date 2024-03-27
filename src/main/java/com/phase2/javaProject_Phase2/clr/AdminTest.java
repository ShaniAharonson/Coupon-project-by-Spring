package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

//@Component
@Order(1)
@RequiredArgsConstructor
public class AdminTest implements CommandLineRunner {
    private final AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- ADMIN TESTING -------------");
        try {
            adminService.adminLogin("admin@admin.com", "admin");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }


        // add company
        try {
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
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        System.out.println("Companies created!");
        System.out.println();

        // update company
        try {
            adminService.updateCompany(Company.builder()
                    .id(4)
                    .name("Google")
                    .email("google@google.com")
                    .password("767676")
                    .build());

            System.out.println("company updated!");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        // delete company
        try {
//        adminService.deleteCompany(4);
            System.out.println("company deleted");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get all companies
        try {
            System.out.println("All companies:");
//        adminService.getAllCompanies().forEach(System.out::println);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }


        // get single company
        try {
            System.out.println("single company:");
//        System.out.println(adminService.getSingleCompany(1));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        // add customer
        try {
            Customer customer1 = Customer.builder()
                    .id(0)
                    .First_Name("ofir")
                    .Last_Name("Aharonson")
                    .email("ofir@ofir.com")
                    .coupon(new Coupon(1, Category.FOOD, "Pasta", "pasta with tomato sauce",
                            Date.valueOf(LocalDate.of(2023, 3, 8)),
                            Date.valueOf(LocalDate.of(2027, 8, 2)), 350, 55.9,
                            "image5"))
                    .password("11223344")
                    .build();
//        adminService.addCustomer(customer1);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer2 = Customer.builder()
                    .id(0)
                    .First_Name("shani")
                    .Last_Name("Aharonson")
                    .email("shani@shani.com")
                    .coupon(new Coupon(2, Category.ELECTRICITY, "XBOX", "Having fun with xbox",
                            Date.valueOf(LocalDate.of(2022, 1, 3)),
                            Date.valueOf(LocalDate.of(2026, 10, 6)), 12, 2000.0,
                            "image6"))
                    .password("99887766")
                    .build();

//        adminService.addCustomer(customer2);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer3 = Customer.builder()
                    .id(0)
                    .First_Name("yael")
                    .Last_Name("Friedman")
                    .email("Yael@Yael.com")
                    .coupon(new Coupon(3, Category.RESTAURANT, "BBB", "Family hamburger deal",
                            Date.valueOf(LocalDate.of(2023, 6, 15)),
                            Date.valueOf(LocalDate.of(2025, 11, 8)), 30, 200.0,
                            "image7"))
                    .password("667788")
                    .build();

            //       adminService.addCustomer(customer3);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer4 = Customer.builder()
                    .id(0)
                    .First_Name("Oshra")
                    .Last_Name("bolandi")
                    .email("oshra@oshra.com")
                    .coupon(new Coupon(1, Category.VACATION, "London", "vacation for one week in london city",
                            Date.valueOf(LocalDate.of(2023, 7, 1)),
                            Date.valueOf(LocalDate.of(2025, 7, 30)), 200, 25.5,
                            "image"))
                    .password("449977")
                    .build();
            //       adminService.addCustomer(customer4);
            System.out.println("new customers added");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            //update customer
//        adminService.updateCustomer(Customer.builder()
//                .id(4)
//                .First_Name("OSHRA")
//                .Last_Name("BOLANDI")
//                .email("oshra@oshra.com")
//                .password("449977")
//                .build());

            System.out.println("customer is updated!");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        try {

//        adminService.deleteCustomer(4);
            System.out.println("customer is deleted");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
        //get all customers
        try {
            System.out.println("All customers:");
//        System.out.println(adminService.getAllCustomers());
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        // get single customer:
        try {
            System.out.println("single customer:");
            System.out.println(adminService.getSingleCustomer(2));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }


}
