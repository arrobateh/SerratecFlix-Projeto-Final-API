package org.serratec.SerratecFlix.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    // Converter a String em uma chave criptografada
    private SecretKey getChave() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Gerar um token JWT
    public String gerarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getChave())
                .compact();
    }

    // Extrair o usuário do token JWT
    private Claims extrairClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getChave())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Verificar o email do usuario
    public String getEmailDoUsuario(String token) {
        Claims claims = extrairClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    // Validação do token
    public boolean validarToken(String token) {
        Claims claims = extrairClaims(token);
        if (claims != null) {
            String username = claims.getSubject();
            Date expiration = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            // Se o token for valido...
            if (username != null && expiration != null && now.before(expiration)) {
                return true;
            }
        }
        return false;
    }
}
