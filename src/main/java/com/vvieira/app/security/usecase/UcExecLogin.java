package com.vvieira.app.security.usecase;

import com.vvieira.app.auth.config.Config;
import com.vvieira.app.auth.dto.LoginDto;
import com.vvieira.app.auth.dto.TokenDto;
import com.vvieira.app.auth.service.TokenService;
import com.vvieira.util.DataUtilService;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Setter
public class UcExecLogin implements UseCase<ResponseEntity> {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataUtilService dataUtilService;

    @Autowired
    private Config config;

    @Autowired
    private TokenService service;

    private LoginDto loginDto;


    @Override
    public ResponseEntity run(){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = service.generateToken(authentication);
        return ResponseEntity.ok(
                TokenDto.builder().
                        token(token)
                        .type("Bearer")
                        .expiration(dataUtilService.expirationTimeTokenFormat(config.getExpiration()))
                        .build());
    }
}
