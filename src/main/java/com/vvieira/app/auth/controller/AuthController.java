package com.vvieira.app.auth.controller;

import com.vvieira.app.auth.dto.TokenDto;
import com.vvieira.app.security.usecase.UcExecLogin;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private Facade facade;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody UcExecLogin uc){
        return facade.run(uc);
    }
}