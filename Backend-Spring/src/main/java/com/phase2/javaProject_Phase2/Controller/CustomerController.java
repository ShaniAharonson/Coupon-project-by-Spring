package com.phase2.javaProject_Phase2.Controller;

import com.phase2.javaProject_Phase2.Utils.JWT;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.beans.Customer;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;
import com.phase2.javaProject_Phase2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController{
    private final JWT jwtUtil;
    private final CustomerService customerService;


//    @PostMapping("/customer_login/{email}/{password}")
//    @ResponseStatus(HttpStatus.OK)
//    public Boolean customerLogin(@PathVariable String email, @PathVariable String password) throws CustomerSystemException {
//        return customerService.customerLogin(email, password);
//    }


    @PostMapping("/purchaseCoupon/{customerId}/{couponId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> purchaseCoupon(@RequestHeader("Authorization") String jwt,@PathVariable int customerId,@PathVariable int couponId) throws Exception {
        return new ResponseEntity<>(customerService.purchaseCoupon(customerId, couponId), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);

    }


    @GetMapping("/allCustomerCoupons/{id}")
    public ResponseEntity<?>  getAllCustomerCoupons(@RequestHeader("Authorization") String jwt,@PathVariable int id) throws Exception {
        return new ResponseEntity<>(customerService.getAllCustomerCoupons(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }

    @GetMapping("/customerCouponsByCategory/{category}/{id}")
    public ResponseEntity<?>  getAllCustomerCouponsByCategory(@RequestHeader("Authorization") String jwt,@PathVariable String category, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(customerService.getAllCustomerCouponsByCategory(category,id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }


    @GetMapping("/customerCouponsByPrice/{maxPrice}/{id}")
    public ResponseEntity<?> getAllCustomerCouponsUpToMaxPrice(@RequestHeader("Authorization") String jwt,@PathVariable Double maxPrice, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(customerService.getAllCustomerCouponsUpToMaxPrice(maxPrice,id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }


    @GetMapping("/customerDetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>  getCustomerDetails(@RequestHeader("Authorization") String jwt,@PathVariable int id) throws Exception {
        return new ResponseEntity<>(customerService.getCustomerDetails(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }
}