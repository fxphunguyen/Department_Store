//package com.phpn.controllers.api;
//
//import com.phpn.dto.employee.EmployeeParam;
//import com.phpn.repositories.model.Employee;
//import com.phpn.repositories.model.JWTResponse;
//import com.phpn.services.authentications.AuthenticationService;
//import com.phpn.services.jwt.JWTService;
//import com.phpn.utils.ApplicationUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/authentication")
//public class AuthenticationAPI {
//
//    @Autowired
//    private ApplicationUtil applicationUtil;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JWTService jwtService;
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody EmployeeParam employeeParam) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeParam.getEmail(), employeeParam.getPassword()));
//            SecurityContextHolder
//            .getContext()
//            .setAuthentication(authentication);
//
//            String jwt = jwtService.generateLoginJWTToken(authentication);
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            Employee employee = authenticationService.getByEmail(employeeParam.getEmail());
//
//            JWTResponse jwtResponse = new JWTResponse(jwt, employee.getId(), userDetails.getUsername(), employee.getName(), userDetails.getAuthorities());
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }
//
//}