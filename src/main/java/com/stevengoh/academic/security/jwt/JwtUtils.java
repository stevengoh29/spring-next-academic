package com.stevengoh.academic.security.jwt;

import com.stevengoh.academic.student.Student;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private final static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public Key getKey () {
            String JWT_SECRET = "HELLO=THIS=IS=A=AUTHENTICATION=FOR=SECURITY=CONFIG=OF=ACADEMIC=DEMO=PROJECT";
            return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
    }

        public String getUsernameFromJwtToken (String token) {
            return Jwts.parserBuilder().setSigningKey(getKey()).build()
                    .parseClaimsJws(token).getBody().getSubject();
        }

        public String issueJWTToken (Authentication authentication) {
            Student principal = (Student) authentication.getPrincipal();

            int JWT_EXPIRATION_MS = 1000000000;

            return Jwts.builder()
                    .setSubject(principal.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION_MS))
                    .signWith(getKey(), SignatureAlgorithm.HS256)
                    .compact();
        }

        public boolean checkTokenIsValid (String token) {
            try {
                Jwts.parserBuilder().setSigningKey(getKey()).build().parse(token);
                return true;
            } catch (MalformedJwtException e) {
                logger.error("Invalid JWT token: {}", e.getMessage());
            } catch (ExpiredJwtException e) {
                logger.error("JWT token is expired: {}", e.getMessage());
            } catch (UnsupportedJwtException e) {
                logger.error("JWT token is unsupported: {}", e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.error("JWT claims string is empty: {}", e.getMessage());
            }

            return false;
        }
}
