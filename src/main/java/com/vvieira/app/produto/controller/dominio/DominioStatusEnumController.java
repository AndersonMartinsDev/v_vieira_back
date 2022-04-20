package com.vvieira.app.produto.controller.dominio;

import com.vvieira.app.produto.casouso.dominio.CasoDominioStatusEnum;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DominioStatusEnumController {

    @Autowired
    private Facade facade;

    @GetMapping("api/dominio/statusenum")
    public List<String> listar(){
        return facade.run(new CasoDominioStatusEnum());
    }
}
