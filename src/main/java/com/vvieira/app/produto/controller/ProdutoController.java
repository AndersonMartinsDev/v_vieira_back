package com.vvieira.app.produto.controller;

import com.vvieira.app.produto.casouso.CasoDeletarProduto;
import com.vvieira.app.produto.casouso.CasoInserirProduto;
import com.vvieira.app.produto.casouso.CasoListarProduto;
import com.vvieira.app.produto.casouso.CasoObterProduto;
import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private Facade facade;

    @GetMapping
    private Iterable<Produto> listar(CasoListarProduto caso) {
        return facade.run(caso);
    }

    @PostMapping
    private void inserir(@RequestBody CasoInserirProduto caso) {
        facade.run(caso);
    }

    @GetMapping("{id}")
    private ProdutoObterDto obter(@PathVariable Long id) {
        CasoObterProduto caso = new CasoObterProduto();
        caso.setId(id);
        return facade.run(caso);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        CasoDeletarProduto caso = new CasoDeletarProduto();
        caso.setId(id);
        facade.run(caso);
    }
}
