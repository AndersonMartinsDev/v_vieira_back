package com.vvieira.app.produto.controller;

import com.vvieira.app.produto.casouso.external.CasoExternalListarProduto;
import com.vvieira.app.produto.casouso.external.CasoExternalObterProduto;
import com.vvieira.app.produto.dto.ProdutoOnlineListarDto;
import com.vvieira.app.produto.dto.ProdutoOnlineObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/external")
public class ProdutoExternalController {

    @Autowired
    private Facade facade;

    @GetMapping("initial/{pageIndex}")
    private ListaPaginada<ProdutoOnlineListarDto> initialPage(@PathVariable Integer pageIndex){
        CasoExternalListarProduto casoExternalListarProduto = new CasoExternalListarProduto();
        casoExternalListarProduto.setPageIndex(pageIndex);
        return facade.run(casoExternalListarProduto);
    }

    @GetMapping("detalhe/{id}")
    private ProdutoOnlineObterDto produto(@PathVariable Long id){
        CasoExternalObterProduto casoExternalObterProduto = new CasoExternalObterProduto();
        casoExternalObterProduto.setId(id);
        return facade.run(casoExternalObterProduto);
    }
}
