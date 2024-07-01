package com.phase2.javaProject_Phase2.services;

import com.phase2.javaProject_Phase2.Repository.UserRepo;
import com.phase2.javaProject_Phase2.beans.*;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponErrMsg;
import com.phase2.javaProject_Phase2.exceptions.CouponExceptions.CouponSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final AdminServiceImp adminServiceImp;
    private final CompanyServiceImp companyServiceImp;
    private final CustomerServiceImp customerServiceImp;

    /*
    private int id;
    private String email;
    private String password;
    private UserType userType;
     */

    public boolean registerUser(UserDetails user) throws Exception{
        if (userRepo.existsById(user.getId())){
            throw new Exception("UserExists");
        }
        adminServiceImp.addCustomer(Customer.builder()
                        .FirstName(user.getName().split("_")[0])
                        .LastName(user.getName().split("_")[1])
                        .password(user.getPassword())
                        .email(user.getEmail())
                .build());
        return true;
    }

    public UserDetails loginUser(Credentials credentials) throws Exception {

        switch (credentials.getUserType()){
            case CUSTOMER:
                int customerId =  customerServiceImp.customerLogin(credentials.getEmail(), credentials.getPassword());
                Customer customer = adminServiceImp.getSingleCustomer(customerId);
                return UserDetails.builder()
                        .name(customer.getFirstName() + '_' + customer.getLastName())
                        .email(customer.getEmail())
                        .userType(UserType.CUSTOMER)
                        .id(customerId)
                        .build();
            case ADMIN:
                if(!credentials.getEmail().equals("admin@admin.com") && !credentials.getPassword().equals("admin")){
                    throw new CouponSystemException(CouponErrMsg.NOT_ADMIN);
                }
                return UserDetails.builder()
                        .name("admin_admin")
                        .email("admin@admin.com")
                        .userType(UserType.ADMIN)
                        .id(1)
                        .build();
            case COMPANY:
                int companyId =  companyServiceImp.companyLogin(credentials.getEmail(), credentials.getPassword());
                Company company = adminServiceImp.getSingleCompany(companyId);
                return UserDetails.builder()
                        .name(company.getName())
                        .email(company.getEmail())
                        .userType(UserType.COMPANY)
                        .id(companyId)
                        .build();
        }
        return null;
    }

//    public void addCredentials(String user, String password, UserType userType, String email) {
//        if (userRepo.findByEmailAndPassword(email, password) == null) {
//            UserDetails userDetails = UserDetails.builder()
//
//                    .name(user)
//                    .password(password)
//                    .userType(userType)
//                    .email(email)
//                    .build();
//            userRepo.save(userDetails);
//        }
//
//    }
}

