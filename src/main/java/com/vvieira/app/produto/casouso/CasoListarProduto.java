package com.vvieira.app.produto.casouso;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.produto.dto.ProdutoListarDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Set;

import static com.vvieira.app.produto.entidade.QProduto.produto;
import static com.vvieira.util.QueryDslExpressionsUtil.*;

@Setter
public class CasoListarProduto implements UseCase<ListaPaginada<ProdutoListarDto>> {

    @Autowired
    private ProdutoRepository produtoRepository;

    private String nome;
    private Set<CaracteristicaEnum> caracteristicas;

    @Override
    public ListaPaginada<ProdutoListarDto> run() {
        BooleanBuilder filtro = new BooleanBuilder();
        //filtro.and(expressionLike(produto.nome, "teste"));
       // filtro.and(expressionDataEquals(produto.dataEntrada,null));
        Page<Produto> page = produtoRepository.findAll(filtro, paginacao(0, Sort.by("id").descending(), 10));
        return new ListaPaginada<>(convert(ProdutoMapper.class).toListProdutoListarDto(page.getContent()), page.getTotalElements(), page.getNumber());

    }
}
