package com.phpn.repositories.model;

import java.util.Collection;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeePrinciple implements UserDetails {

    private static final Long serialVersionUID = 1L;
    private Integer id;
    private String email;
    private String password;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public static EmployeePrinciple build(Employee employee) {
        return new EmployeePrinciple(employee.getId(), employee.getEmail(), employee.getPassword());
    }

}