package com.example.demo.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.example.demo.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTBuilder implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 60 * 1000;
	private String secret="RkqzhzEjo6xuKFPb4jztckDGFz6vLw3+jXuHeWZ9iFINRpflDeJ1VadCMrCuDS0WJWwHRwveR15UzaEiFyDFP6zZ4synqT+DrPaWXJpQ9qum1HB1ORBN/dvLALGE2zDc2uHSEoLxeXEGVQYp";

	public String generateToken(User user) 
	{
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, user.getId() +"");
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) 
	{
		SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
	    String token = Jwts.builder()
	            .signWith(secretKey, SignatureAlgorithm.HS256)
	            .setHeaderParam("typ", "jwt")
	            .setIssuer("acropolis")
	            .setAudience("user")
	            .setSubject(subject)
	            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
	            .compact();
	    return token;
	}


    public Boolean isExpired(String token) {
        return true;
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getClaimFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        return claimsResolver.apply(Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody());
    }

    public String getUserIdFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
}
