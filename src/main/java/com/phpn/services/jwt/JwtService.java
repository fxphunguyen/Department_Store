package com.phpn.services.jwt;

import org.springframework.security.core.Authentication;

public interface JwtService {

    Boolean validateJwtToken(String token);

    String getEmailFromJwtToken(String token);

    String generateJwtTokenLogin(Authentication authentication);

}