package com.phase2.javaProject_Phase2.Controller;

import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import com.phase2.javaProject_Phase2.services.AdminService;
import com.phase2.javaProject_Phase2.services.AdminServiceImp;
import com.phase2.javaProject_Phase2.services.CustomerService;
import com.phase2.javaProject_Phase2.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class GuestController implements GuestService {
    private final GuestService guestService;
    private final AdminService adminService;

    @Override
    @GetMapping("/getSingleCoupon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coupon getSingleCoupon(@PathVariable Integer id) throws CouponSystemException {
        return guestService.getSingleCoupon(id);

    }

    @Override
    @GetMapping("/getAllCoupons")
    public List<Coupon> getAllCoupons() {
        return guestService.getAllCoupons();

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws Exception {
        adminService.addCustomer(customer);

    }
}