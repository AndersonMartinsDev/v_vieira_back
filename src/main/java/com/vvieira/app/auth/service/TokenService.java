package com.vvieira.app.auth.service;

import com.vvieira.app.auth.UserDetailsEntity;
import com.vvieira.app.auth.config.Config;
import com.vvieira.util.DataUtilService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class TokenService {

    private final Config config;

    private final DataUtilService dataUtilService;

    public TokenService(Config config,DataUtilService dataUtilService){
        this.config = config;
        this.dataUtilService = dataUtilService;
    }

    public String generateToken(Authentication authentication) {
        UserDetailsEntity usuario = (UserDetailsEntity) authentication.getPrincipal();
        if (Objects.nonNull(usuario)) {
            return Jwts.builder().setIssuer(config.getProjectName())
                    .setSubject(usuario.getId().toString())
                    .setIssuedAt(new Date())
                    .setExpiration(dataUtilService.calcExpirationToken(config.getExpiration()))
                    .signWith(SignatureAlgorithm.HS256, config.getSecret()).compact();
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(config.getSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getTokenId(String token) {
        Claims body = Jwts.parser().setSigningKey(config.getSecret()).parseClaimsJws(token).getBody();
        return Long.valueOf(body.getSubject());
    }
}