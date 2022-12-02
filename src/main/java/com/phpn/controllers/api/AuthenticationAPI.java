//package com.phpn.controllers.api;
//
//import com.phpn.repositories.model.Employee;
//import com.phpn.services.authentications.AuthenticationService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//@RestController
//@RequestMapping("/api/authentication")
//public class AuthenticationAPI {
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PostMapping("/login")
//    public ResponseEntity<Employee> findByEmailAndPassword(@RequestBody AuthenticationLogin authenticationLogin) {
//        System.out.println("Login API");
//        return new ResponseEntity<>(authenticationService.findByEmailAndPassword(authenticationLogin.getEmail(), authenticationLogin.getPassword()), HttpStatus.OK);
//    }
//
//}