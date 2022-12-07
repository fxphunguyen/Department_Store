//package com.phpn.controllers.api;
//
//import com.phpn.dto.employee.EmployeeLogin;
//
//import com.phpn.repositories.model.Employee;
//import com.phpn.repositories.model.JwtResponse;
//import com.phpn.services.employee.EmployeeService;
//import com.phpn.services.jwt.JwtService;
//import com.phpn.utils.ApplicationUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseCookie;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RestController
//@RequestMapping("/api/authentication")
//public class AuthenticationAPI {
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private ApplicationUtil applicationUtil;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody EmployeeLogin employeeLogin) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeLogin.getEmail(), employeeLogin.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtService.generateJwtToken(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        Employee currentUser = employeeService.getByEmail(employeeLogin.getEmail());
//
//        JwtResponse jwtResponse = new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getEmail());
//        ResponseCookie responseCookie = ResponseCookie.from("JWT", jwt).httpOnly(false).secure(false).path("/").maxAge(60 * 1000).domain("localhost").build();
//
//        System.out.println(jwtResponse);
//
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).body(jwtResponse);
//    }
//
//}