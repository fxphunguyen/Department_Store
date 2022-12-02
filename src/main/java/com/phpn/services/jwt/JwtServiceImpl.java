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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class JwtServiceImpl implements JwtService {

    private static final String SECRET_KEY = "GoiTenToiNheBanThanHoiCoToiLuonCungChiaSotDeRoiTaLaiCoThemNiemTin";
    public static final long JWT_TOKEN_VALIDITY = 1000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class.getName());

    @Override
    public Boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {0} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {0}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {0}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {0}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {0}", e);
        }

        return false;
    }

    @Override
    public String generateJwtToken(Authentication authentication) {
        EmployeePrinciple userPrincipal = (EmployeePrinciple) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_TOKEN_VALIDITY * 60 * 60 * 24 * 30))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    @Override
    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

}