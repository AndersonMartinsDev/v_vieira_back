package com.vvieira.app.produto.controller.dominio;

import com.vvieira.app.produto.casouso.dominio.CasoDominioCaracteristicaEnum;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DominioCaracteristicaController {

    @Autowired
    private Facade facade;

    @GetMapping("api/dominio/caracteristicaenum")
    public List<String> listar(){
        return facade.run(new CasoDominioCaracteristicaEnum());
    }
}
