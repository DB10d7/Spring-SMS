package com.packetPrep.studentmanagementsystem.security;

import com.packetPrep.studentmanagementsystem.exception.SpringManagementException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import static java.util.Date.from;
import static io.jsonwebtoken.Jwts.parser;

@Service
public class JwtProvider {

    private Key key;

    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    @PostConstruct
    public void init() {

        try {
            key= Keys.secretKeyFor(SignatureAlgorithm.HS512);
        } catch (Exception e) {
            throw new SpringManagementException("Exception occurred while loading keystore");
        }
    }
    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(from(Instant.now()))
                .signWith(key)
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }
    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
    public boolean validateToken(String jwt){
        parser().setSigningKey(key).parseClaimsJws(jwt);
        return true;
    }
}
