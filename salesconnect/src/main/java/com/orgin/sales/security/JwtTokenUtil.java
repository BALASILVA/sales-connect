package com.orgin.sales.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7614076026826093646L;
	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE = "audience";
	static final String CLAM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUserNameFromToken(String authToken) {
		String username = null;
		try {
			final Claims claims = getClaimsFromToken(authToken);
		    username=claims.getSubject();
		} catch (Exception e) {
            username=null;
		}
		return username;
	}

	private Claims getClaimsFromToken(String authToken) {
		Claims claims= null;
        try
		{
        	claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken).getBody();
		}
		catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {
		JwtUser user = (JwtUser)userDetails;
		final String username = getUserNameFromToken(authToken);
		return (username.equals(user.getUsername()) && !isTokenExpired(authToken));
	}

	private boolean isTokenExpired(String authToken) {
        final Date expirationData = getExpirationDataFromToken(authToken);
		return expirationData.before(new Date());
	}

	private Date getExpirationDataFromToken(String authToken) {
        Date expirationData =null;
        try
        {
        	final Claims claims = getClaimsFromToken(authToken);
        	if(claims!=null)
        	{
        		expirationData = claims.getExpiration();
        	}
        	else
        	{
        		expirationData = null;
        	}
        }
        catch (Exception e) {
        	expirationData = null;
		}
        return expirationData;
	}

	public String generateToken(JwtUser userDetails) {
        Map<String,Object> clamis = new HashMap<String, Object>();
        clamis.put(CLAM_KEY_USERNAME,userDetails.getUsername());
        clamis.put(CLAM_KEY_CREATED, new Date());
        return generateToken(clamis);
	}

	private String generateToken(Map<String, Object> clamis) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(clamis).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
		
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis()+(expiration)*1000);
	}
}