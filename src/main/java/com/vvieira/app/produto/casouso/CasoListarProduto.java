package com.vvieira.app.produto.casouso;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.produto.dto.ProdutoListarDto;
import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;


import static com.vvieira.app.produto.entidade.QProduto.produto;
import static com.vvieira.util.QueryDslExpressionsUtil.*;

@Setter
public class CasoListarProduto implements UseCase<ListaPaginada<ProdutoListarDto>> {

    @Autowired
    private ProdutoRepository produtoRepository;

    private Integer pageIndex;
    private Integer pageSize;

    @Override
    public ListaPaginada<ProdutoListarDto> run() {
        BooleanBuilder filtro = new BooleanBuilder();
//        filtro.and(expressionLike(produto.nome, filter.getNome()));
        Page<Produto> page = produtoRepository.findAll(filtro, paginacao(pageIndex,pageSize));
        return new ListaPaginada<>(convert(ProdutoMapper.class).toListProdutoListarDto(page.getContent()), page.getTotalElements(), page.getNumber());
    }
}
