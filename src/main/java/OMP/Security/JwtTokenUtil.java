package OMP.Security;

import OMP.Entity.Login;
import OMP.Service.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -3472430070998029466L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    public static final String CLAIM_KEY_ROLE = "role";
    public static final String CLAIM_KEY_USERNAME = "username";
    public static final String CLAIM_KEY_ID = "id";
    private static final String secret = "parola";

    @Autowired
    private LoginService loginService;
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Login user = loginService.logInByUsername(userDetails.getUsername());
        claims.put(CLAIM_KEY_ROLE, user.getRole());
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_ID, user.getUsername());
        return doGenerateToken(claims, userDetails.getUsername());
    }
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}