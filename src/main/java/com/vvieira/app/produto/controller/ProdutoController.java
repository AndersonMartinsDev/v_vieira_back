package com.vvieira.app.produto.controller;

import com.vvieira.app.produto.casouso.CasoListarProduto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.util.structural.Facade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    private Facade facade;

    @GetMapping
    private Iterable<Produto> listar(CasoListarProduto caso){
        return facade.run(caso);
    }
}
