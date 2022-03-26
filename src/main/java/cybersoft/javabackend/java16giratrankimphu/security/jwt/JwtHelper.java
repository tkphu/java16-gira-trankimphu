package cybersoft.javabackend.java16giratrankimphu.security.jwt;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class JwtHelper {
	private String key = "whatissecret";
	
	public String generateJwtToken(String username) {
		
		Date currentDate = new Date();
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(currentDate)
				.setExpiration(new Date(currentDate.getTime() + 86400))
				.signWith(SignatureAlgorithm.HS512, "whatissecret")
				.compact();
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return true;
		}catch(UnsupportedJwtException e1) {
			log.error("JWT token is not supported: {}", e1);
		}catch(MalformedJwtException e2) {
			log.error("Invalid Token: {}", e2);
		}catch(SignatureException e3) {
			log.error("Invalid signature: {}", e3);
		}catch(ExpiredJwtException e4) {
			log.error("JWT is expired: {}", e4);
		}catch(IllegalArgumentException e5) {
			log.error("JWT Claims is empty: {}", e5);
		}
		
		return false;
	}
}