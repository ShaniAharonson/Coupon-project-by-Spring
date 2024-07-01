package com.phase2.javaProject_Phase2.Controller;

import com.phase2.javaProject_Phase2.Utils.JWT;
import com.phase2.javaProject_Phase2.beans.Credentials;
import com.phase2.javaProject_Phase2.beans.UserDetails;
import com.phase2.javaProject_Phase2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService usersService;
    private final JWT jwt;
//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void registerUser(@RequestBody UserDetails data) throws Exception {
//        usersService.registerUser(data);
//    }

//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public Credentials loginUser(@RequestBody UserLogin data) throws Exception{
//        UserDetails userDetails = usersService.loginUser(data);
//        //return to frontend : email,name,token,userType
//        return new Credentials(userDetails.getEmail(),userDetails.getName(),userDetails.getUserType());
//    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Credentials user) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        UserDetails userDetails = usersService.loginUser(user);
        headers.set("Authorization","Bearer "+jwt.generateToken(userDetails));
        return new ResponseEntity<>(true,headers,HttpStatus.OK);
    }
}