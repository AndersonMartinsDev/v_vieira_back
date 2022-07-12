package com.vvieira.app.produto.controller;

import com.vvieira.app.produto.casouso.*;
import com.vvieira.app.produto.dto.ProdutoListarDto;
import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private Facade facade;

    @GetMapping
    private ListaPaginada<ProdutoListarDto> listar(CasoListarProduto caso) {
        return facade.run(caso);
    }

    @PostMapping
    private Produto inserir(@RequestBody CasoInserirProduto caso) {
        return facade.run(caso);
    }

    @PostMapping("{id}")
    private Produto atualizar(@RequestBody CasoAtualizarProduto caso) {
       return facade.run(caso);
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

    @PutMapping("status")
    private ProdutoObterDto atualizarStatus(@RequestBody CasoAtualizarStatusProduto caso){
        return facade.run(caso);
    }
}
