package com.vvieira.app.produto.controller;

import com.vvieira.app.produto.casouso.external.CasoExternalListarProduto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/external")
public class ProdutoExternalController {

    @Autowired
    private Facade facade;

    @GetMapping("initial")
    private List<Produto> initialPage(){
        return facade.run(new CasoExternalListarProduto());
    }

    @GetMapping("detalhe")
    private Produto produto(){
        return facade.run(null);
    }
}
