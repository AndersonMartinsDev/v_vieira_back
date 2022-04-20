package com.vvieira.app.produto.casouso;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.vvieira.app.produto.entidade.QProduto.produto;
import static com.vvieira.util.QueryDslExpressionsUtil.*;

@Setter
public class CasoListarProduto implements UseCase<Iterable<Produto>> {

    @Autowired
    private ProdutoRepository produtoRepository;

    private String nome;
    private List<Long> caracteristicas;

    @Override
    public Iterable<Produto> run() {
        BooleanBuilder filtro = new BooleanBuilder();
        filtro.and(expressionEq(produto.descricao,nome));
        filtro.and(expressionIn(produto.caracteristicas.any().id,caracteristicas));
        return produtoRepository.findAll(filtro);//TODO:PRECISA COMEÇAR A SE PREOCUPAR COM A PAGINAÇÃO AMIGO
    }
}
