package gdsc.fundhub.kantongsosialcampaign.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Component;


import io.jsonwebtoken.*;


@Component
public class JwtUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${user.app.jwtSecret}")
    private String jwtSecret;

    @Value("${user.app.jwtExpirationMs}")
    private int jwtExpirationMs;    


    public String generateJwtToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e){
            logger.error("Invalid JWT Siganture : {}", e.getMessage());
        } catch (MalformedJwtException e){
            logger.error("Invalid JWT Token : {}", e.getMessage());
        } catch (ExpiredJwtException e){
            logger.error("Jwt Token is expired : {}", e.getMessage());
        } catch (UnsupportedJwtException e){
            logger.error("Jwt Token is unsupported : {}", e.getMessage());
        } catch (IllegalArgumentException e){
            logger.error("Jwt claims string is empty : {}", e.getMessage());
        }

        return false;
    }
}
