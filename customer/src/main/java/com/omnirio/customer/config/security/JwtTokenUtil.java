package com.omnirio.customer.config.security;

import com.omnirio.customer.domain.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    private static final String JWT_SECRET = "zdtlD3JK56m6wTTgsNFhqzjqP";
    private static final String JWT_ISSUER = "omnirio.com";
    private static final long ONE_WEEK = 7 * 24 * 60 * 60 * 1000;

    public String generateAccessToken(User user) {
        return Jwts.builder()
            .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
            .setIssuer(JWT_ISSUER)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + ONE_WEEK))
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
            .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
    
    public String getUserId(String token) {
        return getClaims(token).getSubject().split(",")[0];
    }

    public Date getExpirationDate(String token) {
        return getClaims(token).getExpiration();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject().split(",")[1];
    }
    
    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
            .parseClaimsJws(token);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}