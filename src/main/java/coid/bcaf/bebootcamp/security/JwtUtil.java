package coid.bcaf.bebootcamp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;


@Component  // Ensure this annotation is present
public class JwtUtil {
    private String secretKey = "rNqBHpV6k6p8JhNhChm6LfN3oG+vMKueTq5GQ30gbsM=";  // Use a more secure way to handle this

    // Generate token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // Extract username from token
    public String extractUsername(String token) {
        return Jwts.parser()  // No 'builder' method needed
                .verifyWith(getSigningKey()) // Use 'verifyWith' instead of 'setSigningKey'
                .build()  // Build the parser
                .parseSignedClaims(token)  // Use 'parseSignedClaims' instead of 'parseClaimsJws'
                .getPayload()
                .getSubject();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  // Use verifyWith() instead of setSigningKey()
                .build()
                .parseSignedClaims(token)  // Use parseSignedClaims() instead of parseClaimsJws()
                .getPayload()
                .getExpiration();
    }
}
