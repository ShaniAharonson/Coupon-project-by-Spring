package com.phase2.javaProject_Phase2.clr;

import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.Company;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

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
        System.out.println("Add company:");
        try {
            Company company1 = Company.builder()
                    .name("Microsoft")
                    .email("Microsoft@microsoft.com")
                    .password("101010")
                    .build();

            Company company2 = Company.builder()
                    .name("Apple")
                    .email("Apple@apple.com")
                    .password("202020")
                    .build();

            Company company3 = Company.builder()
                    .name("Nvidia")
                    .email("Nvidia@nvidia.com")
                    .password("303030")
                    .build();

            Company company4 = Company.builder()
                    .name("Testing")
                    .email("test@test.com")
                    .password("11121")
                    .build();

            Company company5 = Company.builder()
                    .name("nbbbbbbb")
                    .email("lllll")
                    .password("llllll")
                    .build();

            adminService.addCompany(company1);
            adminService.addCompany(company2);
            adminService.addCompany(company3);
            adminService.addCompany(company4);
            adminService.addCompany(company5);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        System.out.println("Companies created!");
        System.out.println();

        // update company
       System.out.println("update company:");
        try {
            adminService.updateCompany(Company.builder()
                    .id(4)
                    .name("Testing")
                    .email("googlel@google.com")
                    .password("999999")
                    .build());


            System.out.println("company updated!");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
         // delete company
        System.out.println("Delete company:");
        try {
        adminService.deleteCompany(5);
            System.out.println("company deleted");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        //get all companies
        try {
            System.out.println("All companies:");
            adminService.getAllCompanies().forEach(System.out::println);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }


        // get single company
        try {
            System.out.println("single company:");
            System.out.println(adminService.getSingleCompany(1));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
       // add customer
        System.out.println("Adding customers:");
        try {
            Customer customer1 = Customer.builder()
                    .id(0)
                    .FirstName("ofir")
                    .LastName("Aharonson")
                    .email("ofir@ofir.com")
                    .coupon(new Coupon(1, Category.FOOD, "Pasta", "pasta with tomato sauce",
                            Date.valueOf(LocalDate.of(2023, 3, 8)),
                            Date.valueOf(LocalDate.of(2027, 8, 2)), 350, 55.9,
                            "image5"))
                    .password("11223344")
                    .build();
            adminService.addCustomer(customer1);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer2 = Customer.builder()
                    .id(0)
                    .FirstName("shani")
                    .LastName("Aharonson")
                    .email("shani@shani.com")
                    .coupon(new Coupon(2, Category.ELECTRICITY, "XBOX", "Having fun with xbox",
                            Date.valueOf(LocalDate.of(2022, 1, 3)),
                            Date.valueOf(LocalDate.of(2026, 10, 6)), 12, 2000.0,
                            "image6"))
                    .password("99887766")
                    .build();

            adminService.addCustomer(customer2);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer3 = Customer.builder()
                    .id(0)
                    .FirstName("yael")
                    .LastName("Friedman")
                    .email("Yael@Yael.com")
                    .coupon(new Coupon(3, Category.RESTAURANT, "BBB", "Family hamburger deal",
                            Date.valueOf(LocalDate.of(2023, 6, 15)),
                            Date.valueOf(LocalDate.of(2025, 11, 8)), 30, 200.0,
                            "image7"))
                    .password("667788")
                    .build();

            adminService.addCustomer(customer3);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer4 = Customer.builder()
                    .id(0)
                    .FirstName("Oshra")
                    .LastName("bolandi")
                    .email("oshra@oshra.com")
                    .coupon(new Coupon(1, Category.VACATION, "London", "vacation for one week in london city",
                            Date.valueOf(LocalDate.of(2023, 7, 1)),
                            Date.valueOf(LocalDate.of(2025, 7, 30)), 200, 25.5,
                            "image"))
                    .password("449977")
                    .build();
            adminService.addCustomer(customer4);
            System.out.println("new customers added");
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
        try {
            Customer customer5 = Customer.builder()
                    .id(0)
                    .FirstName("Tamir")
                    .LastName("Moradi")
                    .email("Tamir@tamir.com")
                    .password("000001")
                    .coupon(new Coupon(2, Category.VACATION, "berlin", "berlin best city",
                            Date.valueOf(LocalDate.of(2023, 7, 1)),
                            Date.valueOf(LocalDate.of(2025, 7, 30)), 200, 25.5,
                            "image12"))
                    .build();
            adminService.addCustomer(customer5);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
         try {
            //update customer
            adminService.updateCustomer(Customer.builder()
                    .id(4)
                    .FirstName("OSHRA")
                    .LastName("BOLANDI")
                    .email("oshra@oshra.com")
                    .password("449977")
                    .build());

            System.out.println("customer is updated!");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }


        try {
            adminService.deleteCustomer(5);
            System.out.println("customer is deleted");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
        //get all customers
        try {
            System.out.println("All customers:");
            System.out.println(adminService.getAllCustomers());
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
