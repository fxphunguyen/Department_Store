package com.phpn.security;

import com.phpn.services.employee.EmployeeService;
import com.phpn.services.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmployeeService employeeService;

    private String getBearerTokenRequest(HttpServletRequest httpServletRequest) {
        String getAuthorizationHeader = httpServletRequest.getHeader("Authorization");

        if (getAuthorizationHeader != null) {
            if (getAuthorizationHeader.startsWith("Bearer ")) return getAuthorizationHeader.replace("Bearer ", "");
            return getAuthorizationHeader;
        }

        return null;
    }

    private String getCookieValue(HttpServletRequest httpServletRequest) {
        Cookie[] getCookies = httpServletRequest.getCookies();

        if (getCookies != null)
            for (Cookie cookie : getCookies)
                if (cookie.getName().equals("JWT")) return cookie.getValue();

        return null;
    }

    private void setAuthentication(HttpServletRequest httpServletRequest, String authorizationValue) {
        if (authorizationValue != null && jwtService.validateJwtToken(authorizationValue)) {
            UserDetails userDetails = employeeService.loadUserByUsername(jwtService.getEmailFromJwtToken(authorizationValue));
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            String getRequestURI = httpServletRequest.getRequestURI();

            if ("/api/authentication/login".equals(getRequestURI)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }

            setAuthentication(httpServletRequest, getBearerTokenRequest(httpServletRequest));
            setAuthentication(httpServletRequest, getCookieValue(httpServletRequest));

        } catch (Exception exception) {
            logger.error("Can't set user authentication: " + exception.getMessage());
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}