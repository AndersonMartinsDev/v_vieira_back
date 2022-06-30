package com.vvieira.app.produto.casouso.external;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.QProduto;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.QueryDslExpressionsUtil;
import com.vvieira.util.structural.UseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.vvieira.util.QueryDslExpressionsUtil.expressionEq;


public class CasoExternalListarProduto implements UseCase<Iterable<Produto>> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Iterable<Produto> run() {
        BooleanBuilder filtro = new BooleanBuilder();
        filtro.and(QProduto.produto.statusEnum.eq(StatusEnum.PUBLICADO));
        return produtoRepository.findAll(filtro);
    }
}
