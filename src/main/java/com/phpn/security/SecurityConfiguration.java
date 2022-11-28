//package com.phpn.security;
//
//import com.phpn.services.authentications.AuthenticationService;
//import com.phpn.services.employee.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CustomAccessDeniedHandler customAccessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//
////    @Bean
////    public CustomAuthenticationEntryPoint customAuthenticationEntryPoint() {
////        return new CustomAuthenticationEntryPoint();
////    }
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
////    @Autowired
////    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////        authenticationManagerBuilder.userDetailsService(employeeService).passwordEncoder(passwordEncoder());
////    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//        .csrf()
//        .ignoringAntMatchers("/**")
//        .disable();
//
//        httpSecurity
//        .authorizeRequests()
//        .antMatchers("/", "/login", "/logout", "/register", "/api/authentication/**")
//        .permitAll()
//        .antMatchers("/resources/**", "/assets/**")
//        .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin()
//        .loginProcessingUrl("/login")
//        .loginPage("/login")
//        .and()
//        .logout()
//        .logoutUrl("/logout")
//        .logoutSuccessUrl("/login")
//        .deleteCookies("JWT")
//        .invalidateHttpSession(true);
//
////        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).exceptionHandling().accessDeniedPage("/403");
//        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity.cors();
//    }
//
//}