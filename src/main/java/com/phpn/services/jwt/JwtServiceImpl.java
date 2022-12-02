package com.phpn.services.jwt;

import java.util.Date;
import com.phpn.repositories.model.EmployeePrinciple;
import org.springframework.security.core.Authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtServiceImpl implements JwtService {

    private static final Long JWT_TOKEN_VALIDITY = 1000L * 60 * 60;
    private final String SECRET_KEY = "GoiTenToiNheBanThanHoiCoToiLuonCungChiaSotDeRoiTaLaiCoThemNiemTin";
    private final Logger LOGGER = LoggerFactory.getLogger(JwtService.class.getName());

    @Override
    public Boolean validateJwtToken(String token) {
        try {
            Jwts
            .parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token);
            return true;

        } catch (SignatureException signatureException) {
            LOGGER.error("Invalid JWT signature: " + signatureException.getMessage());

        } catch (MalformedJwtException malformedJwtException) {
            LOGGER.error("Invalid JWT token: " + malformedJwtException.getMessage());

        } catch (ExpiredJwtException expiredJwtException) {
            LOGGER.error("Expired JWT token: " + expiredJwtException.getMessage());

        } catch (UnsupportedJwtException unsupportedJwtException) {
            LOGGER.error("Unsupported JWT token: " + unsupportedJwtException.getMessage());

        } catch (IllegalArgumentException illegalArgumentException) {
            LOGGER.error("JWT string is empty: " + illegalArgumentException.getMessage());
        }

        return false;
    }

    @Override
    public String getEmailFromJwtToken(String token) {
        return Jwts
        .parser()
        .setSigningKey(SECRET_KEY)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
    }

    @Override
    public String generateJwtTokenLogin(Authentication authentication) {
        return Jwts
        .builder()
        .setSubject(((EmployeePrinciple) authentication.getPrincipal()).getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + JWT_TOKEN_VALIDITY))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
    }

}