package com.phase2.javaProject_Phase2.Controller;

import com.phase2.javaProject_Phase2.Utils.JWT;
import com.phase2.javaProject_Phase2.beans.Coupon;
import com.phase2.javaProject_Phase2.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class CompanyController  {
    private final JWT jwtUtil;

    private final CompanyService companyService;

//    @PostMapping("/company_login/{email}/{password}")
//    @ResponseStatus(HttpStatus.OK)
//    public Boolean companyLogin(@RequestHeader("Authorization") String jwt,@PathVariable String email, @PathVariable String password) throws CompanySystemException {
//        return new ResponseEntity<>(adminService.deleteCustomer(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
//    }


    @PostMapping("/addCoupon")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addCoupon(@RequestHeader("Authorization") String jwt, @RequestBody Coupon coupon) throws Exception {
        return new ResponseEntity<>(companyService.addCoupon(coupon), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }


    @PutMapping("/updateCoupon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateCoupon(@RequestHeader("Authorization") String jwt, @RequestBody Coupon coupon) throws Exception {
        return new ResponseEntity<>(companyService.updateCoupon(coupon), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);

    }

    @DeleteMapping("/deleteCoupon/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> deleteCoupon(@RequestHeader("Authorization") String jwt, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(companyService.deleteCoupon(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);

    }

    @GetMapping("/allCompanyCoupons/{id}")
    public ResponseEntity<?> getAllCompanyCoupons(@RequestHeader("Authorization") String jwt, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(companyService.getAllCompanyCoupons(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }

    @GetMapping("/companyCouponsCategory/{category}/{id}")
    public ResponseEntity<?> getAllCompanyCouponsByCategory(@RequestHeader("Authorization") String jwt, @PathVariable String category, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(companyService.getAllCompanyCouponsByCategory(category, id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }

    @GetMapping("/companyCouponsMaxPrice/{id}/{maxPrice}")
    public ResponseEntity<?> getAllCompanyCouponsUpToMaxPrice(@RequestHeader("Authorization") String jwt, @PathVariable int id, @PathVariable Double maxPrice) throws Exception {
        return new ResponseEntity<>(companyService.getAllCompanyCouponsUpToMaxPrice(id, maxPrice), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }

    @GetMapping("/companyDetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getCompanyDetails(@RequestHeader("Authorization") String jwt, @PathVariable int id) throws Exception {
        return new ResponseEntity<>(companyService.getCompanyDetails(id), jwtUtil.CheckTheJWT(jwt), HttpStatus.OK);
    }

}